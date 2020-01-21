package homework.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import homework.customer.models.Customer;
import homework.customer.repository.CustomerRepository;



@RestController


public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/GetCustomer/{creditid}")
	public Customer getCustomer(@PathVariable("creditid")int creditid){
		
		return customerRepository.findByCreditId(creditid);
	}
	@RequestMapping("/GetCustomerPesel/{pesel}")
	public Optional<Customer> getCustomer(@PathVariable("pesel")String pesel){
		return customerRepository.findById(pesel);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/CreateCustomer")
	public void createCustomer(@RequestBody Customer cus) {
		if (customerRepository.findById(cus.getPesel()).isPresent()) {
		}
		else {
			customerRepository.save(cus);
		}
		
	}
	

	@RequestMapping("/all")
	public List<Customer> getCustomers(){
		
		//List<Customer> customer = new ArrayList<>();
		//customerRepository.findAll().forEach(customer::add);
		 //return customer;
		
		return (List<Customer>) customerRepository.findAll();
	}
	@RequestMapping("/test")
	public int test(){
return 1;
	}
	
}
