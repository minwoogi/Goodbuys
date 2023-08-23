package com.tu.goodsbuy.service;


import com.tu.goodsbuy.dao.DirectLoginDao;
import com.tu.goodsbuy.dto.MemberUser;

public class DirectLoginService implements LoginService {

    private LoginService INSTANCE;

    public LoginService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DirectLoginService();
        }
        return INSTANCE;
    }


    @Override
    public void checkMemberUser(MemberUser memberUser) {
        DirectLoginDao.getInstance().checkMemberUser(memberUser);
    }

    @Override
    public boolean validateLogin(String id, String pwd) {
        return DirectLoginDao.getInstance().validateLogin(id, pwd);
    }

    @Override
    public boolean isLoginState() {
        return DirectLoginDao.getInstance().isLoginState();
    }
}
