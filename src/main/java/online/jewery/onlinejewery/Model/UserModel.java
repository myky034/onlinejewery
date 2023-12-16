package online.jewery.onlinejewery.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class UserModel {
    @Id
    private String userId;
    private String name;
    private String rollNumber;

    public UserModel() {
    }

    public UserModel(String userId, String name, String rollNumber) {
        super();
        this.userId = userId;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
