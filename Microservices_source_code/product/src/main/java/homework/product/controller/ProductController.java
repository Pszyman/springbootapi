package homework.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import homework.product.models.Product;
import homework.product.repository.ProductRepository;

@RestController

public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/GetProduct/{creditid}")
	public Optional<Product> getProduct(@PathVariable("creditid") int creditid) {

		return productRepository.findById(creditid);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/CreateProduct")
	public void createCustomer(@RequestBody Product prod) {
		productRepository.save(prod);
	}

	@RequestMapping("/all")
	public List<Product> getProduct() {

		// List<Customer> customer = new ArrayList<>();
		// customerRepository.findAll().forEach(customer::add);
		// return customer;

		return (List<Product>) productRepository.findAll();
	}

	@RequestMapping("/test")
	public int test() {

		System.out.println("Product API test - OK");
		return 1;
	}

}
