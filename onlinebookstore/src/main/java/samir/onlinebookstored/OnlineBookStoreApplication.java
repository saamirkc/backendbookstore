package samir.onlinebookstored;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import samir.onlinebookstored.entity.User;
import samir.onlinebookstored.Seervice.UserService;
import samir.onlinebookstored.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samir.onlinebookstored.entity.Role;
import samir.onlinebookstored.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import samir.onlinebookstored.entity.UserRole;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OnlineBookStoreApplication implements CommandLineRunner  {
	@Autowired
	private UserService userService;
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;


		public static void main(String[] args) {
			SpringApplication.run(OnlineBookStoreApplication.class, args);
		}


		public void run(String... args) throws Exception {
			System.out.println("starting code");
//			User user = new User();
//			user.setFirstName("samir");
//			user.setLastName("karki");
//			user.setUsername("samir777");
//			user.setPassword("abc");
//			user.setEmail("sam.777@gmail.com");
//			user.setProfile("default.png");
//			user.setPhone("+9779810277015");
//			User user1 = this.userService.createUser(user);
//			System.out.println(user1.getUsername());
//
//////
			User user= new User();
  user.setFirstName("samir");
  user.setLastName("karki");
  user.setUsername("samir777");
//  user.setPassword("abc");
  user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
  user.setEmail("sam.777@gmail.com");
  user.setProfile("default.png");
  user.setPhone("+9779810277015");
        Role role =new Role();
        role.setRoleId(9L);
        role.setRoleName("ADMIN");
        Set<UserRole> userRoleSet=new HashSet<>();
        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleSet.add(userRole);
        User user1=this.userService.createUser(user,userRoleSet);
        System.out.println(user1.getUsername());

		}


	}
