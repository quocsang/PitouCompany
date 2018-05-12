package com.ctu.tqsang.dao;

import java.util.List;

import com.ctu.tqsang.domain.Category;

public interface CategoryDAO {

    List<Category> findAll();
    
    Category findOne(int id);
    
    Category findOne(String name);
    
    int count();
    
    void create(Category category);

    void update(Category category);

    void delete(Category category);
    
}
