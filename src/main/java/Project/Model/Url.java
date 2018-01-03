package Project.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

import java.util.Date;

@Entity
    @Table(name = "Url")
    public class Url implements Serializable {

        private static final long serialVersionUID = 368875986784459499L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        @Getter
        @Setter
        private long id;

        @Column(name="chaine")
        @Getter @Setter private String chaine;

        @Column(name="code")
        @Getter @Setter private String code;

        @Column(name = "createdAt")
        @Getter @Setter private Date createdAt;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_user", nullable = false)
        @Getter @Setter private User user;

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
        String code="";
        for (int i = 0; i < 3; i++)
        {
            code += (boucle.nextInt(26) + 'a');

        }
        for (int i = 0; i < 3; i++)
        {
            code += boucle.nextInt(10);
        }
        return code;
    }



}
