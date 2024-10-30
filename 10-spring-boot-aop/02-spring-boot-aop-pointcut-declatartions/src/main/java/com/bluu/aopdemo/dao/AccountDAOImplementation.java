package com.bluu.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImplementation implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public String getName() {
        System.out.println(getClass() + " getName");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + " setName");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() +  " setServiceCode");
        this.serviceCode = serviceCode;
    }

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
