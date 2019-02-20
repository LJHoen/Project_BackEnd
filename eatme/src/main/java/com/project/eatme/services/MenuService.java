package com.project.eatme.services;

import com.project.eatme.domain.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuService extends CrudRepository<Menu, Integer> {
}
