package com.bluu.aopdemo.dao;

public interface AccountDAO {

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    void addAccount(String userName, String userEmail);
    void addAdminAccount(String userName);
    void addManagerAccount();
}
