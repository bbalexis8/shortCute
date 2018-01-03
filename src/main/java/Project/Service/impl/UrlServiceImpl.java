package Project.Service.impl;

        import Project.DAO.UrlDAO;
        import Project.Model.Url;
        import Project.Service.UrlService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDAO urlDAO;

    @Override
    public long add(Url url) {
        return urlDAO.add(url);
    }

    @Override
    public Url getById(long id, boolean lazy) {

        return urlDAO.getById(id,lazy);
    }

    @Override
    public void delete(Url user) {

        urlDAO.delete(user);
    }
}
