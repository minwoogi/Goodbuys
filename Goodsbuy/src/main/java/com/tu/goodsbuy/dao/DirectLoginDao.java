package com.tu.goodsbuy.dao;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.util.DbConnection;

public class DirectLoginDao implements LoginDao {


    private DbConnection dbConnection;

    private static DirectLoginDao INSTANCE;

    public DirectLoginDao(DbConnection dbconnection) {
        this.dbConnection = dbconnection;
    }

    public DirectLoginDao() {

    }

    public static DirectLoginDao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DirectLoginDao();
        }
        return INSTANCE;
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
