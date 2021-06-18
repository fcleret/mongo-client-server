package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Partner;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PartnersRepository extends MongoRepository<Partner, ObjectId>, PartnersRepositoryCustom {

    List<Partner> findAll();

    List<Partner> findByName(String name);
}
