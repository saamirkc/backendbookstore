package samir.onlinebookstored.Controller;
import org.jboss.logging.BasicLogger;
import org.springframework.http.HttpStatus;
import samir.onlinebookstored.Configgforjwt.JwtUtils;
import samir.onlinebookstored.entity.JwtRequest;
import samir.onlinebookstored.entity.JwtResponse;
import samir.onlinebookstored.entity.User;
import samir.onlinebookstored.Seervice.UserDetailsServiceImpl;
import samir.onlinebookstored.Seervice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    //generate  token
    @PostMapping("/generate-token")

    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found");
        }
//authenticate
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER DISABLED" + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials" + e.getMessage());
        }

    }
//    @GetMapping("/current-user")
//    public User getCurrentUser(Principal principal){
//
//            return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
//        }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
        } else {
            // Handle the case where principal is null
            // You might want to return an error response or take alternative actions
            return null; // or throw an exception or return a default user
        }
    }


}







