package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Partner;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PartnersRepository extends MongoRepository<Partner, ObjectId>, PartnersRepositoryCustom {

    /**
     * Récupère tout les partenaires
     * @return une liste de partenaires
     */
    List<Partner> findAll();

    /**
     * Récupère un partenaire selon son nom
     * @param name correspond au nom
     * @return une liste de partenaires
     */
    List<Partner> findByName(String name);
}
