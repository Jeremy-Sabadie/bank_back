package model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")

public class Client {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTelephone;
    private String banqueId;
    private String username;
    private String password;

    public Client() {
    }

    public Client(String nom, String prenom, String adresse, String numeroTelephone, String banqueId) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.banqueId = banqueId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getBanqueId() {
        return banqueId;
    }

    public void setBanqueId(String banqueId) {
        this.banqueId = banqueId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

