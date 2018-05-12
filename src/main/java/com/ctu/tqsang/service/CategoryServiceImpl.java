package com.ctu.tqsang.service;

import com.ctu.tqsang.dao.CategoryDAO;
import com.ctu.tqsang.domain.Categoryquestion;
import com.ctu.tqsang.util.StringUtil;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;
    
    @Override
    public List<Categoryquestion> findAll() {
        return categoryDAO.findAll();
    }
    
    @Override
    public Categoryquestion findOne(int id) {
        return categoryDAO.findOne(id);
    }
    
    @Override
    public Categoryquestion findOne(String name) {
        return categoryDAO.findOne(name);
    }
    
    @Override
    public int count() {
        return categoryDAO.count();
    }

    @Override
    public void create(Categoryquestion category) {
    	category.setSlug(StringUtil.slugify(category.getName()));
        categoryDAO.create(category);
    }

    @Override
    public void update(Categoryquestion category) {
    	category.setSlug(StringUtil.slugify(category.getName()));
        categoryDAO.update(category);
    }

    @Override
    public void delete(Categoryquestion category) {
        categoryDAO.delete(category);
    }

}
