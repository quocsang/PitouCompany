package com.ctu.tqsang.service;

import java.util.List;

import com.ctu.tqsang.domain.Category;

public interface CategoryService {

    List<Category> findAll();
    
    Category findOne(int id);
    
    Category findOne(String name);

    int count();
    
    void create(Category category);

    void update(Category category);

    void delete(Category category);
    
}
