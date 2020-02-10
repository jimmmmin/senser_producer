package com.example.myapp.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    AccountMapper accountMapper;

    public Account save(Account account,String role){
        accountMapper.insertUser(account);
        accountMapper.insertUserAuthority(account.getId(), role);
        return account;
    }

    public Account findById(String username) {
        // TODO Auto-generated method stub
        return accountMapper.readAccount(username);
    }

    public List<String>findAuthoritiesByID(String username){
        return accountMapper.readAuthorities(username);
    }

}
