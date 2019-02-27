package com.project.eatme.controllers;

import com.project.eatme.domain.Account;
import com.project.eatme.domain.ChefAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.eatme.services.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class ChefAccountController {

    @Autowired private ChefAccountService chefAccountService;

    @ResponseBody
    @RequestMapping(value = "/chefs/register", method = RequestMethod.POST)
    public long createAccount (@RequestBody ChefAccount account) {
        return chefAccountService.save(account).getId();
    }

    @ResponseBody
    @RequestMapping(value="/chefs/authenticate", method = RequestMethod.POST)
    public Account checkAccount ( @RequestBody ChefAccount account ) {
        Iterable<ChefAccount> accounts = chefAccountService.findAll();
        for(Account a : accounts) {
            if(a.getUsername().equals(account.getUsername()) && a.getPassword().equals(account.getPassword())) {
                return a;
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/chefs/{id}", method = RequestMethod.PUT)
    public long updateAccount(@PathVariable  long id, @RequestBody ChefAccount account) {
        return chefAccountService.save(account).getId();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/chefs/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable  long id) {
        chefAccountService.deleteById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/chefs.{id}", method = RequestMethod.DELETE)
    public void  deleteAccount(@PathVariable ChefAccount account) { chefAccountService.delete(account); }

    @ResponseBody
    @RequestMapping(value = "/chefs", method = RequestMethod.GET)
    public List<ChefAccount> findAll() {
        return (List<ChefAccount>) chefAccountService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/chefs/{id}", method = RequestMethod.GET)
    public ChefAccount accountById(@PathVariable  long id) {
        // .get() niet rechtstreeks. Eerst checken en evt exception geven
         return chefAccountService.findById(id).get();
    }
}
