package samir.onlinebookstored.Controller;

import samir.onlinebookstored.entity.User;
import samir.onlinebookstored.Seervice.UserService;
import samir.onlinebookstored.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import samir.onlinebookstored.entity.Role;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {
    @Autowired
    private UserService userService;

//@Autowired
//private ModelMapper modelMapper;

//    @Autowired
//    private UserService userService;
    //creating user
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/")

    public User createUser(@RequestBody User user) throws Exception {

        System.out.println("hello");
        user.setProfile("default.png");
//        encoding password with bcryptpassword encoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());
        Set<UserRole> roles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(8L);
        role.setRoleName("NORMAL");
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }


    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String user){
        return this.userService.getUser(user);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){
        this.userService.deleteUser(userId);

    }

//    public UserDTO userDTO(User user){
//       UserDTO userDTO= this.modelMapper.map(user,UserDTO.class);
//       return userDTO;
//    }


}
