package pl.edu.pjwstk.jaz;


import org.aspectj.weaver.patterns.ExactTypePattern;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private UserRepository userRepository;

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService, UserRepository userRepository){
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest){

        //  uwierzytelnić

        if(userRepository.findByUsername(loginRequest.getUsername()).isEmpty()) {
            throw new UnauthorizedException();
        }

        if(userRepository.findByUsername(loginRequest.getUsername()).isPresent()) {
            var user = userRepository.findByUsername(loginRequest.getUsername());

            if(user.isPresent())
            if(user.get().login.equals( loginRequest.getUsername() ) || user.get().password.equals( loginRequest.getPassword()) ){

            }
        }

        
        //var isLogged = authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword());
                //if(!isLogged){
                    //throw new UnauthorizedException();
               // }
    }

}
