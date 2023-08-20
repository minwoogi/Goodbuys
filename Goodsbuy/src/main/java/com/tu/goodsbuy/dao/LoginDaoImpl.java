package com.tu.goodsbuy.dao;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.util.DbConnection;

public class LoginDaoImpl implements LoginDao {


    private final DbConnection dbConnection;

    public LoginDaoImpl(DbConnection dbconnection) {
        this.dbConnection = dbconnection;
    }

    @Override
    public boolean isLoginState() {
        return false;
    }

    @Override
    public void checkMemberUser(MemberUser memberUser) {

    }

    @Override
    public boolean validateLogin(String id, String pwd) {
        return false;
    }

}
