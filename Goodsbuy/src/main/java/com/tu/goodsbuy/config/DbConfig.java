package com.tu.goodsbuy.config;

import com.tu.goodsbuy.dao.LoginDao;
import com.tu.goodsbuy.dao.DirectLoginDao;
import com.tu.goodsbuy.util.DbConnection;
import com.tu.goodsbuy.util.MysqlConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {


    @Bean
    public LoginDao loginDao() {
        return new DirectLoginDao(dbConnection());
    }

    @Bean
    public DbConnection dbConnection() {
        return new MysqlConnection();
    }

}
