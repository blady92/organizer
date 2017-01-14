package pl.lodz.ftims.pp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;
    private String login;
    private String password;
    private String eMail;
    private String firstName;
    private String secondName;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account(Long idAccount, String login, String password, String firstName, String secondName) {
        this.idAccount = idAccount;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
