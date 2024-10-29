package com.bluu.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImplementation implements AccountDAO {


    @Override
    public void addAccount(String userName, String userEmail) {
        System.out.println("add account " + userName);
    }

    @Override
    public void addAdminAccount(String userName) {
        System.out.println("add admin " + userName);
    }

    @Override
    public void addManagerAccount() {
        System.out.println("add manager");
    }
}
