package io.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class NetflixStreamingUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixStreamingUserApplication.class, args);
	}

	@Bean
	@LoadBalanced  
	public RestTemplate restTemplate2() {
		return new RestTemplate();
	}

}
