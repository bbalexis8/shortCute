package Project.DAO;

import Project.Model.Url;

import java.util.List;

public interface UrlDAO {

    public Long add(Url Url);

    public Url getById(long id, boolean lazy);

    public void delete(Url url);

    public Url getByCode(String code);

    public List getLast(int limite);
}
