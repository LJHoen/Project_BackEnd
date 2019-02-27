package com.project.eatme.controllers;

import com.project.eatme.domain.Account;
import com.project.eatme.domain.KlantAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.eatme.services.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class KlantAccountController {

    @Autowired
    private KlantAccountService klantAccountService;

    @ResponseBody
    @RequestMapping(value = "/klanten/register", method = RequestMethod.POST)
    public long createAccount (@RequestBody KlantAccount account) {
        return klantAccountService.save(account).getId();
    }

    @ResponseBody
    @RequestMapping(value="/klanten/authenticate", method = RequestMethod.POST)
    public Account checkAccount ( @RequestBody KlantAccount account ) {
        Iterable<KlantAccount> accounts = klantAccountService.findAll();
        for(Account a : accounts) {
            if(a.getUsername().equals(account.getUsername()) && a.getPassword().equals(account.getPassword())) {
                return a;
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/klanten/{id}", method = RequestMethod.PUT)
    public KlantAccount updateAccount(@PathVariable  long id, @RequestBody KlantAccount account) {
        klantAccountService.save(account).getId();
        return account;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/klanten/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable  long id) {
        klantAccountService.deleteById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/klanten", method = RequestMethod.GET)
    public List<KlantAccount> findAll() {
        return (List<KlantAccount>) klantAccountService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/klanten/{id}", method = RequestMethod.GET)
    public KlantAccount accountById(@PathVariable  long id) {
        return klantAccountService.findById(id).get();
    }
}
