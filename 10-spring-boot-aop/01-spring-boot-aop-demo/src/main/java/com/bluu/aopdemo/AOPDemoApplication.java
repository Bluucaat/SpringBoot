package com.bluu.aopdemo;

import com.bluu.aopdemo.dao.AccountDAO;
import com.bluu.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.addAccount("name1", "email@mail.com");
		membershipDAO.addAccount("name3", "email@mail.com", "new");
		accountDAO.addAdminAccount("name2");
		accountDAO.addManagerAccount();
	}
}