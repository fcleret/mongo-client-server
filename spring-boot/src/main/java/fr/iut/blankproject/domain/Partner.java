package fr.iut.blankproject.domain;

import fr.iut.blankproject.domain.partnerCollection.Contact;
import fr.iut.blankproject.domain.partnerCollection.Location;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "partners")
public class Partner {

    @Id
    private ObjectId id;
        public ObjectId getId() { return id; }
        public void setId(ObjectId value) { id = value; }

    private String name;
        public String getName() { return name; }
        public void setName(String value) { name = value; }

    private Contact contact;
        public Contact getContact() { return contact; }
        public void setContact(Contact value) { contact = value; }

    private Location location;
        public Location getLocation() { return location; }
        public void setLocation(Location value) { location = value; }

    private ObjectId websiteId;
        public ObjectId getWebsiteId() { return websiteId; }
        public void setWebsiteId(ObjectId value) { websiteId = value; }

    private List<User> account;
        public List<User> getAccount() { return account; }
        public void setAccount(List<User> value) { account = value; }
}
