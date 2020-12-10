package pl.edu.pjwstk.jaz;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    User first_admin = new User("admin", "admin", "admin", true);
    User first_user = new User("user", "user", "user", false);


    private Map<String, User> userMap = new HashMap<>() {{
        put(first_admin.login, first_admin);
        put(first_user.login, first_user);
    }};


    public void add(String username, String password, String name){
        User user = new User(username, password, name, false);
        userMap.put(username, user);
    }

    public Optional<User> findByUsername(String username){

        User user = userMap.get(username);

        return Optional.ofNullable(user);
    }
}
