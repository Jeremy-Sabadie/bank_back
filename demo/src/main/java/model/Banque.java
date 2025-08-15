package model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Document(collection = "banques")
public class Banque {

    @Id
    private ObjectId id;           // Utilisation de ObjectId pour correspondre à MongoDB
    private String nom;
    private String adresse;
    private List<ObjectId> employes;  // IDs des employés
    private List<ObjectId> clients;   // IDs des clients

    public Banque() {
    }

    public Banque(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    // Getters et Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<ObjectId> getEmployes() {
        return employes;
    }

    public void setEmployes(List<ObjectId> employes) {
        this.employes = employes;
    }

    public List<ObjectId> getClients() {
        return clients;
    }

    public void setClients(List<ObjectId> clients) {
        this.clients = clients;
    }
}
