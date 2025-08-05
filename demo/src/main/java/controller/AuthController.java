package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Client;
import model.Employe;
import service.AuthService;
@RestController
@RequestMapping("/api/auth")
public class AuthController{

    @Autowired
    private AuthService authService;

    @PostMapping("/login/employe")
    public ResponseEntity<String> loginEmploye(@RequestBody LoginRequest loginRequest) {
        Employe employe = authService.authenticateEmploye(loginRequest.getUsername(), loginRequest.getPassword());
        if (employe != null) {
            return ResponseEntity.ok("Login successful for employee: " + employe.getNom());
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/login/client")
    public ResponseEntity<String> loginClient(@RequestBody LoginRequest loginRequest) {
        Client client = authService.authenticateClient(loginRequest.getUsername(), loginRequest.getPassword());
        if (client != null) {
            return ResponseEntity.ok("Login successful for client: " + client.getNom());
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register/employe")
    public ResponseEntity<String> registerEmploye(@RequestBody RegisterEmployeRequest registerRequest) {
        Employe newEmploye = authService.registerEmploye(
            registerRequest.getNom(),
            registerRequest.getPrenom(),
            registerRequest.getPoste(),
            registerRequest.getBanqueId(),
            registerRequest.getUsername(),
            registerRequest.getPassword()
        );
        if (newEmploye != null) {
            return ResponseEntity.ok("Registration successful for employee: " + newEmploye.getNom());
        } else {
            return ResponseEntity.badRequest().body("Registration failed");
        }
    }

    @PostMapping("/register/client")
    public ResponseEntity<String> registerClient(@RequestBody RegisterClientRequest registerRequest) {
        Client newClient = authService.registerClient(
            registerRequest.getNom(),
            registerRequest.getPrenom(),
            registerRequest.getAdresse(),
            registerRequest.getNumeroTelephone(),
            registerRequest.getBanqueId(),
            registerRequest.getUsername(),
            registerRequest.getPassword()
        );
        if (newClient != null) {
            return ResponseEntity.ok("Registration successful for client: " + newClient.getNom());
        } else {
            return ResponseEntity.badRequest().body("Registration failed");
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;

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

    public static class RegisterEmployeRequest {
        private String nom;
        private String prenom;
        private String poste;
        private String banqueId;
        private String username;
        private String password;

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

    public static class RegisterClientRequest {
        private String nom;
        private String prenom;
        private String adresse;
        private String numeroTelephone;
        private String banqueId;
        private String username;
        private String password;

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
}
