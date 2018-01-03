package Project.DAO;

import Project.Model.Url;

public interface UrlDAO {

    public Long add(Url Url);

    public Url getById(long id, boolean lazy);

    public void delete(Url url);
}
