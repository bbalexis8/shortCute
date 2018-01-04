package Project.Controller;


import Project.Model.Url;
import Project.Model.User;
import Project.Service.UrlService;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.*;
import javax.validation.constraints.Max;
import java.util.List;

@Controller
@SessionAttributes(value = "User", types = { User.class })
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UrlService urlService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main(ModelMap modelMap, HttpSession httpSession){

        // Ajouter les éléments à la vue
        modelMap.addAttribute("Url", new Url());
        modelMap.addAttribute("liste", urlService.getLast(10));
        modelMap.addAttribute("urlCount", urlService.getUrlCount());
        modelMap.addAttribute("userCount", userService.getUserCount());
        return "Main/index";
    }

    @RequestMapping( method = RequestMethod.POST , value = "/addUrl")
    public String addUrl(@ModelAttribute("Url") @Valid Url url, BindingResult result, HttpSession httpSession) {

        // Vérification des erreurs
        url.validate(url, result);
        if (result.hasErrors()) {
            return "Main/index";
        }

        System.out.println("lol");

            // Ajout dans la base de données de l'url via un service
            urlService.add(url);
            return "redirect:/?code=" + url.getCode();
    }


}
