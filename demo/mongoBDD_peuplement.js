use banqueDB;

// Insertion des banques
db.banques.insertMany([
  {
    nom: "Banque Centrale",
    adresse: "10 rue de la Finance",
    employes: [],
    clients: []
  },
  {
    nom: "Banque Populaire",
    adresse: "25 avenue des Marchés",
    employes: [],
    clients: []
  }
]);

// Récupérer les IDs des banques insérées
const banques = db.banques.find().toArray();

// Insertion des employés
db.employes.insertMany([
  {
    nom: "Dupont",
    prenom: "Jean",
    poste: "Gestionnaire",
    banqueId: banques[0]._id,   // garder ObjectId ici
    username: "jdupont",
    password: "pass123"
  },
  {
    nom: "Martin",
    prenom: "Claire",
    poste: "Caissière",
    banqueId: banques[1]._id,
    username: "cmartin",
    password: "pass456"
  }
]);

// Insertion des clients
db.clients.insertMany([
  {
    nom: "Durand",
    prenom: "Alice",
    adresse: "12 rue des Lilas",
    numeroTelephone: "0601020304",
    banqueId: banques[0]._id,
    username: "adurand",
    password: "clientpass"
  },
  {
    nom: "Lemoine",
    prenom: "Paul",
    adresse: "8 avenue des Champs",
    numeroTelephone: "0605060708",
    banqueId: banques[1]._id,
    username: "plemoine",
    password: "clientpass2"
  }
]);

// Récupérer les IDs des clients insérés
const clients = db.clients.find().toArray();

// Insertion des comptes
db.comptes.insertMany([
  {
    numeroCompte: "FR1234567890",
    solde: 1500.0,
    dateOuverture: new Date("2023-01-15"),
    typeCompte: "Courant",
    clientId: clients[0]._id,
    transactions: []
  },
  {
    numeroCompte: "FR0987654321",
    solde: 3200.5,
    dateOuverture: new Date("2024-03-20"),
    typeCompte: "Épargne",
    clientId: clients[1]._id,
    transactions: []
  }
]);

// Récupérer les IDs des comptes insérés
const comptes = db.comptes.find().toArray();

// Insertion des transactions
db.transactions.insertMany([
  {
    montant: 200.0,
    date: new Date("2024-05-10"),
    type: "Débit",
    compteSource: comptes[0]._id,
    compteDestination: comptes[1]._id
  },
  {
    montant: 500.0,
    date: new Date("2024-05-11"),
    type: "Crédit",
    compteSource: comptes[1]._id,
    compteDestination: comptes[0]._id
  }
]);

// Mise à jour des listes employes et clients dans chaque banque
banques.forEach(banque => {
  const employesBanque = db.employes.find({ banqueId: banque._id }).map(e => e._id);
  const clientsBanque = db.clients.find({ banqueId: banque._id }).map(c => c._id);

  db.banques.updateOne(
    { _id: banque._id },
    { $set: { employes: employesBanque, clients: clientsBanque } }
  );
});

print("Populations terminées !");
