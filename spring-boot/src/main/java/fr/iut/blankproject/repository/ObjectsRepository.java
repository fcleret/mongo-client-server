package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ObjectsRepository extends MongoRepository<Object, ObjectId>, ObjectsRepositoryCustom {

    List<Object> findAll();

    List<Object> findByName(String name);
}
