package com.bluu.aopdemo;

import com.bluu.aopdemo.dao.AccountDAO;
import com.bluu.aopdemo.dao.MembershipDAO;
import com.bluu.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AOPDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AOPDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoTheBeforeAdvice(accountDAO, membershipDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		boolean tripWire = true;
		System.out.println("My fortune is: " + trafficFortuneService.getFortune(true));
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("My fortune is: " + trafficFortuneService.getFortune());
	}


	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.addAccount("name1", "email@mail.com");
		membershipDAO.addAccount("name3", "email@mail.com", "new");
		accountDAO.addAdminAccount("name2");
		accountDAO.addManagerAccount();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addAccount("name4", "email@mail.com", "new");
	}
}
