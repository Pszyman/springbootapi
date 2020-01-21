package homework.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories
@SpringBootApplication
public class ProductApplication {

	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		//HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		//clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
