package service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import model.Client;
import model.Employe;
import repositories.ClientRepository;
import repositories.EmployeRepository;

public class AuthService{

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Employe authenticateEmploye(String username, String password) {
        Employe employe = employeRepository.findByUsername(username);
        if (employe != null && Objects.equals(employe.getPassword(), password)) {
            return employe;
        }
        return null;
    }

    public Client authenticateClient(String username, String password) {
        Client client = clientRepository.findByUsername(username);
        if (client != null && Objects.equals(client.getPassword(), password)) {
            return client;
        }
        return null;
    }

    public Employe registerEmploye(String nom, String prenom, String poste, String banqueId, String username, String password) {
        if (employeRepository.findByUsername(username) != null) {
            return null;
        }

        Employe newEmploye = new Employe(nom, prenom, poste, banqueId);
        newEmploye.setUsername(username);
        newEmploye.setPassword(password);
        return employeRepository.save(newEmploye);
    }

    public Client registerClient(String nom, String prenom, String adresse, String numeroTelephone, String banqueId, String username, String password) {
        if (clientRepository.findByUsername(username) != null) {
            return null;
        }

        Client newClient = new Client(nom, prenom, adresse, numeroTelephone, banqueId);
        newClient.setUsername(username);
        newClient.setPassword(password);
        return clientRepository.save(newClient);
    }
}
