package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.ObjectCount;
import fr.iut.blankproject.domain.objectCollection.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

public class ObjectsRepositoryImpl implements ObjectsRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ObjectsRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Object> findLastAdded() {
        List<AggregationOperation> list = new ArrayList<>();
        list.add(Aggregation.sort(Sort.Direction.DESC, "creationDate"));
        list.add(Aggregation.limit(1));

        TypedAggregation<Object> agg = Aggregation.newAggregation(Object.class, list);
        return mongoTemplate.aggregate(agg, Object.class).getMappedResults();
    }

    @Override
    public List<ObjectCount> countAll() {
        AggregationOperation group = Aggregation.group("color").count().as("count");
        AggregationOperation project = Aggregation.project("count").and("color").previousOperation();
        Aggregation aggregation = Aggregation.newAggregation(group, project);

        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(Object.class), ObjectCount.class).getMappedResults();
    }
}
