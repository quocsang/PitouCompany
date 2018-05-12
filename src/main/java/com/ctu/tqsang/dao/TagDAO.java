package com.ctu.tqsang.dao;

import java.util.List;

import com.ctu.tqsang.domain.Tag;

public interface TagDAO {

    List<Tag> findAllApp();
    
    List<Tag> findAllAdmin();
    
    Tag findOne(int id);

    Tag findOne(String name);
    
    int count();
    
    void create(Tag tag);

    void update(Tag tag);

    void delete(Tag tag);
    
}
