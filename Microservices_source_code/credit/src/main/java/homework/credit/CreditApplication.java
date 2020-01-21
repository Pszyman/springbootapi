package homework.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class CreditApplication {

	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		//HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		//clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CreditApplication.class, args);
	}

}
