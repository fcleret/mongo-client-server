package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.Partner;
import fr.iut.blankproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

public class PartnersRepositoryImpl implements PartnersRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PartnersRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Récupère un partenaire selon son nom (avec son compte correspondant)
     * @param name correspond au nom
     * @return une liste de partenaires
     */
    @Override
    public List<Partner> findAccountByName(String name) {
        List<AggregationOperation> list = new ArrayList<>();
        list.add(Aggregation.match(Criteria.where("name").is(name)));
        list.add(Aggregation.lookup("users","websiteId","_id","account"));

        TypedAggregation<Partner> agg = Aggregation.newAggregation(Partner.class, list);
        return mongoTemplate.aggregate(agg, Partner.class).getMappedResults();
    }
}
