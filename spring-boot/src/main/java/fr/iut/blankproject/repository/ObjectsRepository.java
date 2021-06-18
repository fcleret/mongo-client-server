package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ObjectsRepository extends MongoRepository<Object, ObjectId>, ObjectsRepositoryCustom {

    /**
     * Récupère tout les objets
     * @return une liste d'objets
     */
    List<Object> findAll();

    /**
     * Récupère un objet selon son nom
     * @param name correspond au nom
     * @return une liste d'objets
     */
    List<Object> findByName(String name);
}
