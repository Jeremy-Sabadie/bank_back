package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean; // <- important !
import model.Client;
import com.example.demo.repositories.ClientRepository;
import jakarta.annotation.PostConstruct; // bien importer PostConstruct

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private ClientRepository clientRepository;
    

    public void afficherClients() {
        List<Client> clients = clientRepository.findAll();
        System.out.println("Clients récupérés : " + clients);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    public void run(String... args) throws Exception {
        List<Client> clients = clientRepository.findAll();
        System.out.println("Clients récupérés : " + clients);
    }
    @PostConstruct
    public void testClients() {
        List<Client> clients = clientRepository.findAll();
        System.out.println("Clients récupérés : " + clients.size());
        clients.forEach(c -> System.out.println(c.getNom() + " - " + c.getBanqueId()));
    }

    @Bean
    CommandLineRunner testMongoConnection(ClientRepository clientRepository) {
        return args -> {
            System.out.println("🔍 Test de connexion MongoDB et récupération des clients...");
            var clients = clientRepository.findAll();
            System.out.println("Clients récupérés : " + clients.size());
            clients.forEach(c ->
                System.out.println("➡ " + c.getNom() + " " + c.getPrenom() + " | BanqueId: " + c.getBanqueId())
            );
        };
    }
}

