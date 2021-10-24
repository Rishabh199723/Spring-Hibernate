package com.spring.restServices.repository;

import com.spring.restServices.entity.Laptop;
import com.spring.restServices.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    HibernateTemplate template;

    @Autowired
    SessionFactory factory;

    @Transactional
    public String saveUser(User user) {
        template.save(user);
        return "SAVED";
    }
    @Transactional
    public String deleteUser(Long id) {
        User u = template.get(User.class, id);
        template.delete(u);
        return "deleted";
    }

    public List<Laptop> fetchLaptops(Long id) {
        User u = fetchuser(id);
        return u.getLaptops();
    }

    public User fetchuser(Long id) {
        return template.get(User.class, id);
    }

    public List<Object[]> fetchUserWithHQL(Long id) {
        Session s = factory.openSession();
        Query q = s.createQuery("Select u.id, u.name, u.rollNo, l.name from User as u INNER JOIN u.laptops as l ");
//        q.setParameter("id", id);
        return (List<Object[]>)q.list();
    }

    public User fetchUserWithCriteria(Long id) {
        Session s = factory.openSession();
        Criteria c = s.createCriteria(User.class);
        c.add(Restrictions.eq("id",id));
        return (User)c.uniqueResult();

    }



}
