package fr.iut.blankproject.domain;

import fr.iut.blankproject.domain.objectCollection.Dimension;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "objects")
public class Object {

    @Id
    private ObjectId id;
        public ObjectId getId() { return id; }
        public void setId(ObjectId value) { id = value; }

    private String name;
        public String getName() { return name; }
        public void setName(String value) { name = value; }

    private List<String> color;
        public List<String> getColor() { return color; }
        public void setColor(List<String> value) { color = value; }

    private Dimension dimension;
        public Dimension getDimension() { return dimension; }
        public void setDimension(Dimension value) { dimension = value; }

    private Date creationDate;
        public Date getCreationDate() { return creationDate; }
        public void setCreationDate(Date value) { creationDate = value; }
}
