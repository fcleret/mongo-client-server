package fr.iut.blankproject.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;
        public ObjectId getId() { return id; }
        public void setId(ObjectId value) { id = value; }

    private String username;
        public String getUsername() { return username; }
        public void setUsername(String value) { username = value; }

    private String password;
        public String getPassword() { return password; }
        public void setPassword(String value) { password = value; }

    private String status;
        public String getStatus() { return status; }
        public void setStatus(String value) { status = value; }
}
