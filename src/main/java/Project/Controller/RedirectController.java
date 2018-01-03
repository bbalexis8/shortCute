package Project.Controller;

import Project.Model.Url;
import Project.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "Url", types = {Url.class })
public class RedirectController {

    @Autowired
    private UrlService urlService;

    @RequestMapping (value = "/{code}")

    @PathVariable String code
}
