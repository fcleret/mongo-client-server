package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<User, ObjectId> {

    List<User> findAll();

    List<User> findByUsername(String username);
}
