package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Document(collection = "client")  // Assure que Spring pointe vers la bonne collection
public class Client {

    @Id
    private ObjectId id;               // Correspond à _id dans MongoDB
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTelephone;
    private ObjectId banqueId;         // Référence à la banque
    private String username;
    private String password;

    // Constructeur par défaut
    public Client() {}

    // Constructeur avec paramètres (sans username/password)
    public Client(String nom, String prenom, String adresse, String numeroTelephone, ObjectId banqueId) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.banqueId = banqueId;
    }

    // Getters et setters
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getNumeroTelephone() { return numeroTelephone; }
    public void setNumeroTelephone(String numeroTelephone) { this.numeroTelephone = numeroTelephone; }

    public ObjectId getBanqueId() { return banqueId; }
    public void setBanqueId(ObjectId banqueId) { this.banqueId = banqueId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
