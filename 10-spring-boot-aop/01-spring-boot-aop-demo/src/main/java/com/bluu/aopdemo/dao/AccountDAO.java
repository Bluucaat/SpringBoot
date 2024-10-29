package com.bluu.aopdemo.dao;

public interface AccountDAO {
    void addAccount(String userName, String userEmail);
    void addAdminAccount(String userName);
    void addManagerAccount();
}
