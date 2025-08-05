package model;

import org.springframework.data.annotation.Id;

public class Employe{
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String poste;
    private String banqueId;
    private String username;
    private String password;

    public Employe() {
    }

    public Employe(String nom, String prenom, String poste, String banqueId) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
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
