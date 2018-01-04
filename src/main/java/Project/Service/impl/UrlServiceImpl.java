package Project.Service.impl;

        import Project.DAO.UrlDAO;
        import Project.Model.Url;
        import Project.Service.UrlService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

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

    public Url getByCode(String code){

        return urlDAO.getByCode(code);
    }

    public List getLast(int limite){
        return urlDAO.getLast(limite);
    }

    public long getUrlCount() {
        return urlDAO.getUrlCount();
    }

    @Override
    public void delete(Url user) {

        urlDAO.delete(user);
    }
}
