package samir.onlinebookstored.Seervice;
import samir.onlinebookstored.entity.User;
import samir.onlinebookstored.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samir.onlinebookstored.entity.UserRole;
import java.util.Set;
import samir.onlinebookstored.repository.RoleRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local= this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User already there!");
            throw new Exception("User already created");
        }
        else{
            //user created
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepository.save(user);
        }

        return local;
    }
    //getting user by username
    @Override
    public User getUser(String user) {
        return this.userRepository.findByUsername(user);
    }

    //delete by userid
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }





}
