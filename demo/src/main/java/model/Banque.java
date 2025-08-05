package model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "banques")

public class Banque {
	   @Id
	    private String id;
	    private String nom;
	    private String adresse;
	    private List<String> employes;
	    private List<String> clients;

	    public Banque() {
	    }

	    public Banque(String nom, String adresse) {
	        this.nom = nom;
	        this.adresse = adresse;
	    }

	    // Getters et Setters
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

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public List<String> getEmployes() {
	        return employes;
	    }

	    public void setEmployes(List<String> employes) {
	        this.employes = employes;
	    }

	    public List<String> getClients() {
	        return clients;
	    }

	    public void setClients(List<String> clients) {
	        this.clients = clients;
	    }
	}

