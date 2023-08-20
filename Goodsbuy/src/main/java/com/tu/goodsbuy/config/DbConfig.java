package com.tu.goodsbuy.config;

import com.tu.goodsbuy.dao.LoginDao;
import com.tu.goodsbuy.dao.LoginDaoImpl;
import com.tu.goodsbuy.util.MysqlConnection;

public class DbConfig {

    public LoginDao loginDao() {
        return new LoginDaoImpl(new MysqlConnection());
    }
}
