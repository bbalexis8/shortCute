package Project.DAO;

import Project.Model.Url;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public class UrlDAOimpl implements UrlDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long add(Url url) {
        Serializable id = sessionFactory.getCurrentSession().save(url);
        return (Long) id;
    }

    @Override
    public Url getById(long id, boolean lazy) {
        Url url = sessionFactory.getCurrentSession().get(Url.class, id);
        if (lazy)
            Hibernate.initialize(url.getCode());
        return url;
    }


    public Url getByCode(String code) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Url WHERE code = :code");
        query.setParameter("code", code);

        return (Url) query.getSingleResult();
    }



    @Override
    public void delete(Url url) {
        sessionFactory.getCurrentSession().remove(url);

    }
}
