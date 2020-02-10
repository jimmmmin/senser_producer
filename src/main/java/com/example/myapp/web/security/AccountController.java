package com.example.myapp.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired AccountMapper accountMapper;

    //ADMIN 계정 부여
    @GetMapping("/create")
    public Account create(){
        Account account=new Account();
        account.setId("admin");
        account.setPassword("1234");
        accountService.save(account, "ROLE_ADMIN");
        return account;
    }

    //서비스 권한 부여


}
