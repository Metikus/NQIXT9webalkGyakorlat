package com.example.SemTaskNQIXT9.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SemTaskNQIXT9.entity.Menu;
import com.example.SemTaskNQIXT9.service.MenuService;

@Controller
public class MainController {
	  @Autowired
	    private MenuService menuService;

	    @GetMapping("/menu")
	    public String index(Model model) throws IOException {
	        model.addAttribute("list", menuService.findAll());
	        return "menu";
	    }

	    @GetMapping("/recipe={ID}")
	    public String formUpdate(@PathVariable(value = "ID") String id, Model model) throws IOException {
	        try {
	            model.addAttribute("menu", menuService.findById(Integer.parseInt(id)));
	        } catch (NumberFormatException e) {

	        }
	        return "recipe";

	    }

	    @GetMapping("/recipe")
	    public String formInsert(Model model) throws IOException {
	        model.addAttribute("menu", new Menu());
	        return "recipe";
	    }

	    @PostMapping("/update")
	    public String formSubmit(@ModelAttribute Menu menu, Model model) {
	        model.addAttribute("menu", menu);
	        menuService.save(menu);
	        return "refresh";
	    }

	    @GetMapping("/delete={ID}")
	    public String delete(@PathVariable(value = "ID") String id, Model model) throws IOException {
	        try {
	            menuService.delete(menuService.findById(Integer.parseInt(id)));
	        } catch (NumberFormatException e) {

	        }
	        return "refresh";

	    }
}