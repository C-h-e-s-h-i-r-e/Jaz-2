package pl.edu.pjwstk.jaz;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    UserRepository userRepository;

    public RegisterController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest){
        if(userRepository.findByUsername(registerRequest.getUsername()).isEmpty()){

            userRepository.add(registerRequest.getUsername(), registerRequest.getPassword() ,registerRequest.getName());
        }
    }
}
