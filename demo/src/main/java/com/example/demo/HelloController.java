package com.example.demo;
import java.util.List;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Client;
@RestController
public class HelloController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hy")
    public String sayHy() {
        return "Salut stucru";
    }

    // Endpoint pour récupérer tous les clients
    @GetMapping("/clients")
    public List<model.Client> getAllClients() {
        List<model.Client> clients = clientRepository.findAll();
        System.out.println("Clients récupérés : " + clients);
        return clients;
    }
}
