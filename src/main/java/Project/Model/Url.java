package Project.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

import java.util.Date;

@Entity
    @Table(name = "Url")
    public class Url implements Serializable, Validator {

    private static final long serialVersionUID = 368875986784459499L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "chaine")
    @Getter
    @Setter
    private String chaine;

    @Column(name = "code")
    @Getter
    @Setter
    private String code;

    @Column(name = "createdAt")
    @Getter
    @Setter
    private Date createdAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = true)
    @Getter
    @Setter
    private User user;

    public Url() {

    }

    public Url(String chaine, User user) {
        this.chaine = chaine;
        this.user = user;
        this.createdAt = new Date();
        this.code = setCode();
    }

    public Url(String chaine) {
        this.chaine = chaine;
        this.createdAt = new Date();
        this.code = setCode();
    }

    private String setCode() {
        Random boucle = new Random();
        String code = "";
        for (int i = 0; i < 3; i++) {
            code += (char) (boucle.nextInt(26) + 'a');

        }
        for (int i = 0; i < 3; i++) {
            code += boucle.nextInt(10);
        }
        return code;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "NotEmpty.url.chaine");

        // Validate an url
        if (urlValidator(chaine))
            System.out.print("The given URL " + chaine + " is valid");
        else
            System.out.print("The given URL " + chaine + " is not  valid");
    }


    public static boolean urlValidator(String url)
    {
        /*validating url*/
        try {
            new URL(url).toURI();
            return true;
        }
        catch (URISyntaxException exception) {
            System.out.println("bad url");
            return false;
        }

        catch (MalformedURLException exception) {
            return false;
        }
    }

}
