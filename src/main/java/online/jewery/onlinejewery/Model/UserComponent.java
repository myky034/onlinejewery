package online.jewery.onlinejewery.Model;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
