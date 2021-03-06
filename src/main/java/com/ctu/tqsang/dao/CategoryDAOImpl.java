package com.ctu.tqsang.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctu.tqsang.domain.Categoryquestion;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Categoryquestion> findAll() {
    	Session session = sessionFactory.getCurrentSession();
    	
    	String hql = "select distinct c " + 
    				 "from Categoryquestion c " +
    				 "left join fetch c.questions";
    	
    	return session.createQuery(hql).getResultList();
    }
    
    @Override
    public Categoryquestion findOne(int id) {
    	Session session = sessionFactory.getCurrentSession();
        return session.get(Categoryquestion.class, id);
    }
    
    @Override
    public Categoryquestion findOne(String name) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	String hql = "from Categoryquestion " +
    	             "where name = :name";
    	
    	try {
    		return (Categoryquestion) session.createQuery(hql)
    				.setParameter("name", name)
                    .getSingleResult();
    	} catch (NoResultException e) {
    		return null;
    	}
    }
    
    @Override
    public int count() {
    	Session session = sessionFactory.getCurrentSession();
    	
    	String hql = "select count(*) " + 
            	     "from Categoryquestion";
    	
        return ((Number) session.createQuery(hql).getSingleResult()).intValue();
    }
    
    @Override
    public void create(Categoryquestion category) {
    	Session session = sessionFactory.getCurrentSession();
        session.persist(category);
    }

    @Override
    public void update(Categoryquestion category) {
    	Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public void delete(Categoryquestion category) {
    	Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }

}
