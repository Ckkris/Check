package TestConfigManuelle.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by christophe on 3/17/2015.
 */


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long login;
    private String nom;
    private String prenom;

    protected Client() {
    }

    public Client( String nom, String prenom) {
        this.prenom = prenom;
        this.nom = nom;
    }

@Override
public String toString() {
    return String.format("Client[login=%d, nom='%s', prenom='%s']", login, nom, prenom);
    }

}
