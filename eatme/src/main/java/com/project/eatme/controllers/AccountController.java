package com.project.eatme.controllers;

import com.project.eatme.domain.Account;
import com.project.eatme.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.eatme.services.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;


    @ResponseBody
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public long createAccount (@RequestBody Account account) {
        return accountService.save(account).getId();
    }

    @ResponseBody
    @RequestMapping(value="/users/authenticate", method = RequestMethod.GET)
    public boolean checkAccount (@PathVariable String username, String password) {
        Iterable<Account> accounts = accountService.findAll();
        for(Account a : accounts) {
            if(a.getUsername() == username && a.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public long updateAccount(@PathVariable  long id, @RequestBody Account account) {
        return accountService.save(account).getId();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void updateAccount(@PathVariable  long id) {
        accountService.deleteById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/users.{id}", method = RequestMethod.DELETE)
    public void  updateAccount(@PathVariable Account account) { accountService.delete(account); }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Account> findAll() {
        return (List<Account>) accountService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Optional<Account> accountById(@PathVariable  long id) {
        return accountService.findById(id);
    }

}
