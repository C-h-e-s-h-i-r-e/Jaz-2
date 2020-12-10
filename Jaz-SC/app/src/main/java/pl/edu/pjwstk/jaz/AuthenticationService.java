package pl.edu.pjwstk.jaz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthenticationService {

    UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public boolean login(String username, String password) {



        var user = new User(username,password);

        SecurityContextHolder.getContext().setAuthentication(new AppAuthentication(user));

        return false;
    }
}
