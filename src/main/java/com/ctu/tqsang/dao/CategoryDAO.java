package com.ctu.tqsang.dao;

import java.util.List;

import com.ctu.tqsang.domain.Categoryquestion;

public interface CategoryDAO {

    List<Categoryquestion> findAll();
    
    Categoryquestion findOne(int id);
    
    Categoryquestion findOne(String name);
    
    int count();
    
    void create(Categoryquestion category);

    void update(Categoryquestion category);

    void delete(Categoryquestion category);
    
}
