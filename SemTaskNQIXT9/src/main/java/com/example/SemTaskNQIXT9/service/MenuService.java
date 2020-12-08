package com.example.SemTaskNQIXT9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SemTaskNQIXT9.entity.Menu;
import com.example.SemTaskNQIXT9.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
    private MenuRepository menuRepository;

    public List<Menu> findAll() {
        return (List<Menu>) menuRepository.findAll();
    }

    public Menu findById(Integer id) {
        return menuRepository.findById(id).get();
    }

    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

}
