package Project.Service;

import Project.Model.Url;

import java.util.List;

public interface UrlService {

    public long add(Url url);

    public Url getById(long id, boolean lazy);

    public void delete(Url url);

    public Url getByCode(String code);

    public List getLast(int limite);

    public long getUrlCount();
}