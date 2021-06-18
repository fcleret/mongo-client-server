package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<User, ObjectId> {

    /**
     * Récupère tout les utilisateurs
     * @return une liste d'utilisateurs
     */
    List<User> findAll();

    /**
     * Récupère un utilisateur selon son identifiant
     * @param username correspond à l'identifiant
     * @return une liste d'utilisateurs
     */
    List<User> findByUsername(String username);
}
