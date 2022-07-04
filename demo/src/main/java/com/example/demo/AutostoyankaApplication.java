package com.example.demo;

import Enities.Authorizations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AutostoyankaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutostoyankaApplication.class, args);
	}

}

@Component
class AuthorizationsCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		for (Authorizations a: this.authorizationsRepository.findAll())
			System.out.println(a.toString());
	}
	@Autowired AuthorizationsRepository authorizationsRepository ;
}

@Repository
interface AuthorizationsRepository extends JpaRepository<Authorizations, Long>{
	Collection<Authorizations> findAuthorizationsByLogin(String Login);

	@Override
	Optional<Authorizations> findById(Long aLong);
}

@RestController
class AuthorizationsRestController{
	@RequestMapping("/authorization")
	Collection<Authorizations> authorizations(){
		return this.authorizationsRepository.findAll();
	}
	@Autowired AuthorizationsRepository authorizationsRepository;
}