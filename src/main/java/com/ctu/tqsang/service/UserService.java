package com.ctu.tqsang.service;

import java.util.List;

import com.ctu.tqsang.domain.User;

public interface UserService {

    List<User> findAll();
    
    List<User> findLast(int limit);
    
    List<User> findTopPoint(int limit);
    
    User findOne(int id);
    
    User findOne(String email);
    
    int count();
    
    void create(User user, String role);
    
    void update(User user);
    
    void update(User user, String role);
    
    void upPoint(int uid, int point);
    
    void downPoint(int uid, int point);
    
    void delete(User user);

}
