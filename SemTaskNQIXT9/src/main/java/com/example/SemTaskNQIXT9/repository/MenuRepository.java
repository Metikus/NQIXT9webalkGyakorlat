package com.example.SemTaskNQIXT9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SemTaskNQIXT9.entity.Menu;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {

}