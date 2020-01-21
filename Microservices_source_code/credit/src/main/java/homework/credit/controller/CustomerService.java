package homework.credit.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import homework.credit.models.Credit;
import homework.credit.models.Customer;


@Service
public class CustomerService {

	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(
			fallbackMethod = "getFallbackCustomer",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")					
					}
	)
	Customer getCustomer(int id) {
		return restTemplate.getForObject("http://customer:8082/GetCustomer/" + id, Customer.class);
	}
	
	 Customer getFallbackCustomer(int id) {
		return new Customer("pesel error", "first name error", "surname error", new ArrayList<Credit>());
	}
	 
	 
}
