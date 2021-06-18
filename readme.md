# Projet Client/Serveur
# -----
# Cleret Francis


## Installation

Cloner le projet avec git :
 - git remote add origin https://github.com/fcleret/mongo-client-server.git

Aller dans le dossier "spring-boot":
 - cd spring-boot

Télécharger les packages avec maven :
 - mvn clean package

Lancer le serveur :
 - mvn spring-boot:run


Accès au site via : http://localhost:8080/


## Documentation

Il y a trois tables:
- User -> utilisateur
- Partner -> partenaire
- Object -> objet

Un partenaire (commercial) peut avoir un idenfiant de connexion pour le site (la table 'user')
Un objet est créé afin d'être revendu à différents clients


Pour plus d'informations sur la base de données, voir le fichier "Documentation.pdf".


Liste des urls:
Méthode | URL			| Paramètres			| Description
-------------------------------------------------------------------------------------------------------------------------
GET	| /partners		|				| Récupère tout les partenaires
GET	| /getPartner		| String name			| Récupère un partenaire selon son nom
GET	| /getPartner/account	| String name			| Récupère un partenaire selon son nom (avec son compte correspondant)
POST	| /partner		| Partner entity		| Créer un partenaire
PUT	| /partnerUpdate/{id}	| Partner entity, String id	| Met à jour un partenaire selon son "_id"
DELETE	| /partnerDelete/{id}	| String id			| Supprimer un partenaire selon son "_id"
-------------------------------------------------------------------------------------------------------------------------
GET	| /users		|				| Récupère tout les utilisateurs
GET	| /getUser		| String username		| Récupère un utilisateur selon son identifiant
POST	| /user			| User entity			| Créer un utilisateur 
PUT	| /userUpdate/{id}	| User entity, String id	| Met à jour un utilisateur selon son "_id"
DELETE	| /userDelete/{id}	| String id			| Supprimer un utilisateur selon son "_id"
-------------------------------------------------------------------------------------------------------------------------
GET	| /objects		|				| Récupère tout les objets
GET	| /getObject		| String name			| Récupère un objet selon son nom
POST	| /objects/last		|				| Récupère le dernier objet (selon la date de création)
POST	| /objects/count	|				| Récupère les groupes d'objets ayant la même couleur et donne leur nombre
POST	| /object		| Object entity			| Créer un objet 
PUT	| /objectUpdate/{id}	| Object entity, String id	| Met à jour un objet selon son "_id"
DELETE	| /objectDelete/{id}	| String id			| Supprimer un objet selon son "_id"