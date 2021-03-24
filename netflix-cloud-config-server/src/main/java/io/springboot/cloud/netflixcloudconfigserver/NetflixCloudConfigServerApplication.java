package io.springboot.cloud.netflixcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NetflixCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixCloudConfigServerApplication.class, args);
	}

}
