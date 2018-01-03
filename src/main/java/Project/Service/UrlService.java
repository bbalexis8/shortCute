package Project.Service;

import Project.Model.Url;

public interface UrlService {

    public long add(Url url);

    public Url getById(long id, boolean lazy);

    public void delete(Url url);
}