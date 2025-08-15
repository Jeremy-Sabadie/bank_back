// DROP collections si elles existent
db.banques.drop();
db.employes.drop();
db.clients.drop();
db.comptes.drop();
db.transactions.drop();

// 1. Insert Banques et récupérer leurs IDs
const banqueCentraleId = db.banques.insertOne({
  nom: "Banque Centrale",
  adresse: "12 Rue de Paris",
  employes: [],
  clients: []
}).insertedId;

const banqueNationaleId = db.banques.insertOne({
  nom: "Banque Nationale",
  adresse: "45 Avenue de Lyon",
  employes: [],
  clients: []
}).insertedId;

// 2. Insert Employes en utilisant banqueId
const employeDurandId = db.employes.insertOne({
  nom: "Durand",
  prenom: "Pierre",
  poste: "Conseiller",
  banqueId: banqueCentraleId,
  username: "pierre.d",
  password: "pass123"
}).insertedId;

const employeMartinId = db.employes.insertOne({
  nom: "Martin",
  prenom: "Sophie",
  poste: "Directrice",
  banqueId: banqueNationaleId,
  username: "sophie.m",
  password: "pass456"
}).insertedId;

// 3. Insert Clients avec banqueId
const clientDupontId = db.clients.insertOne({
  nom: "Dupont",
  prenom: "Jean",
  adresse: "10 Rue Victor Hugo",
  numeroTelephone: "0612345678",
  banqueId: banqueCentraleId,
  username: "jean.dupont",
  password: "pass111"
}).insertedId;

const clientBernardId = db.clients.insertOne({
  nom: "Bernard",
  prenom: "Lucie",
  adresse: "25 Boulevard Saint-Michel",
  numeroTelephone: "0698765432",
  banqueId: banqueNationaleId,
  username: "lucie.bernard",
  password: "pass222"
}).insertedId;

// 4. Insert Comptes avec clientId
const compte1Id = db.comptes.insertOne({
  numeroCompte: "FR1234567890",
  solde: 2500.50,
  dateOuverture: new Date("2022-01-15"),
  typeCompte: "Courant",
  clientId: clientDupontId,
  transactions: []
}).insertedId;

const compte2Id = db.comptes.insertOne({
  numeroCompte: "FR0987654321",
  solde: 5000.00,
  dateOuverture: new Date("2023-05-20"),
  typeCompte: "Épargne",
  clientId: clientBernardId,
  transactions: []
}).insertedId;

// 5. Insert Transactions avec compteSource et compteDestination
const transaction1Id = db.transactions.insertOne({
  montant: 200.00,
  date: new Date("2024-03-10"),
  type: "Virement",
  compteSource: compte1Id,
  compteDestination: compte2Id
}).insertedId;

const transaction2Id = db.transactions.insertOne({
  montant: 1000.00,
  date: new Date("2024-04-05"),
  type: "Dépôt",
  compteSource: null,
  compteDestination: compte1Id
}).insertedId;

// 6. Mettre à jour les transactions dans les comptes (références)
db.comptes.updateOne(
  { _id: compte1Id },
  { $set: { transactions: [transaction1Id, transaction2Id] } }
);

db.comptes.updateOne(
  { _id: compte2Id },
  { $set: { transactions: [transaction1Id] } }
);

// 7. Mettre à jour les banques avec les employés et clients (références)
db.banques.updateOne(
  { _id: banqueCentraleId },
  {
    $set: {
      employes: [employeDurandId],
      clients: [clientDupontId]
    }
  }
);

db.banques.updateOne(
  { _id: banqueNationaleId },
  {
    $set: {
      employes: [employeMartinId],
      clients: [clientBernardId]
    }
  }
);
