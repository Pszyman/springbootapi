package homework.credit.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

//import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.web.bind.annotation.RequestMapping;

import homework.credit.repository.CreditRepository;
import homework.credit.models.*;

@RestController
public class CreditController {
	@Autowired
	private CreditRepository creditRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	// Rest function which returning all credits
	@RequestMapping("/GetCredits")
	public List<CreditInfo> getCreditInfo() {
		// creating credit object from credit database
		List<Credit> credits = new ArrayList<>();
		creditRepository.findAll().forEach(credits::add);
		List<CreditInfo> creditInfo = new ArrayList<>();

		// creating final returning object with all information regarding credit
		for (Credit c : credits) {

			// for each entity from credit GET REST request is sending to microservices and
			// getting data from cutomer and product database
			Customer customer = customerService.getCustomer(c.getId());
			Product product = productService.getProduct(c.getId());
			creditInfo.add(new CreditInfo(c.getPesel(), customer.getFirstname(), customer.getSurname(),
					product.getProductname(), product.getValue(), c.getId(), c.getCreditname()));
		}
		return creditInfo;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/CreateCredit")
@HystrixCommand(fallbackMethod = "getFallbackCreateCredit" )
	public int createCredit(@RequestBody CreditInfo2 cred) {

		// Checking PESEL length is ok
		if (cred.getPesel().length() == 11) {

			// Checking if PESEL is numeric
			if (isNumeric(cred.getPesel())) {

				// checking last highest id of credit and setting id for new credit
				int i = setCreditId();
				//Checking if product API works. If not then fallback method will be started
				int a=restTemplate.getForObject("http://product:8083/test/", Integer.class);

				// sending customer Object to microservice "customer" via REST Post.
				Customer cust = new Customer(cred.getPesel(), cred.getName(), cred.getSurname(),
						new ArrayList<Credit>());
				restTemplate.postForObject("http://customer:8082/CreateCustomer", cust, Customer.class);

				// Writing Cerdit to database
				Credit cr = new Credit(i, cred.getCreditname(), cred.getPesel());
				creditRepository.save(cr);

				// sending customer Object to microservice "product" via REST Post.
				Product prod = new Product(i, cred.getProductname(), cred.getProductvalue());
				restTemplate.postForObject("http://product:8083/CreateProduct", prod, Product.class);
				// return new credit id
				return i;
			}

			// if PESEL is not numeric
			else {
				peselNotNumeric();
				System.out.println("Pesel is not numeric");
				return 0;
			}
		}

		// If PESEL is wrong then it will be written
		else {
			wrongPeselLength();
			System.out.println("Wrong PESEL Legth");
			return 0;
		}

	}
	
	public int getFallbackCreateCredit(@RequestBody CreditInfo2 cred) {
		System.out.println("One of API is down. Operation not possibe!");
		return 0;
	}

	// Setting new credit Id. Taking first highest number
	private int setCreditId() {
		List<Credit> credits = new ArrayList<>();
		creditRepository.findAll().forEach(credits::add);
		int i = 0;
		for (Credit c : credits) {
			if (c.getId() > i) {
				i = c.getId();
			}
		}
		return ++i;
	}

	// function returning information if PESEL has wrong length
	private String wrongPeselLength() {
		return "Not proper PESEL length";
	}

	// function returning information if PESEL is not numeric
	private String peselNotNumeric() {
		return "PESEL is not numeric";
	}

	// function returning information if PESEL is not a number
	private static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@RequestMapping("/Hello")
	public String hello() {
		return "Hello";
	}

}
