package com.bluu.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImplementation implements MembershipDAO {


    @Override
    public void addAccount(String userName, String userEmail, String accountType) {
        System.out.println("add membership account " + userName);
    }
}
