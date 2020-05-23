package nl.zdzislaw.verhuur_voertuig.service;

import nl.zdzislaw.verhuur_voertuig.model.Users.User;
import nl.zdzislaw.verhuur_voertuig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private static final String DEFAULT_ROLE = "ROLE_USER";

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository=userRepository;

    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addWithDefaultRole(User user){
        Date registerDate= Calendar.getInstance().getTime();
        user.setRegisterDate(registerDate);
        user.setRoleName(DEFAULT_ROLE);
        String passwordHash=passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }

    public List<User> showAllUsers(){
       List<User>users=userRepository.findAll();
        return users;
    }
    public User findByUsername(String username){
        User user =userRepository.findByUsername(username);
        return user;
    }

}
