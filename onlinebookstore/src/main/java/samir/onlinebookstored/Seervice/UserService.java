package samir.onlinebookstored.Seervice;

import java.util.Set;

import samir.onlinebookstored.entity.User;


import samir.onlinebookstored.entity.UserRole;


//import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //get user by username
    public User getUser(String user);
    //delete user by userid
    public void deleteUser(Long userId);



}
