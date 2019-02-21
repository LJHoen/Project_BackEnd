/*
package com.project.eatme.controllers;

import com.project.eatme.domain.*;
import com.project.eatme.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public long createMenu (@RequestBody Menu menu) {return menuService.save(menu).getId(); }

    @ResponseBody
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<Menu> findAll() { return (List<Menu>)menuService.findAll(); }

    @ResponseBody
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public Optional<Menu> menuById(@PathVariable  int id) {
        return menuService.findById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
    public void updateMenu(@PathVariable  int id) {
        menuService.deleteById(id);
    }
}
*/
