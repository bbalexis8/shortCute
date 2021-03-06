package Project.DAO;

import Project.Model.Url;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

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

    public List getLast(int limite) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Url order by createdAt ASC");
        query.setMaxResults(limite);
        return query.getResultList();
    }

    public long getUrlCount() {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from Url");
        return (long) query.getSingleResult();
    }


    @Override
    public void delete(Url url) {
        sessionFactory.getCurrentSession().remove(url);

    }
}
