package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.dto.UserLoginDto;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDto userLoginDto){
        Optional<UserEntity> byUsername = userRepository.findByUsername(userLoginDto.getUsername());

        if (byUsername.isEmpty()){
            LOGGER.debug("User with name [{}] not found.", userLoginDto.getUsername());
            return false;
        }
        var rowPassword = userLoginDto.getPassword();
        var hashPassword= byUsername.get().getPassword();

        boolean success = passwordEncoder.matches(rowPassword,hashPassword);

        if (success){
            login(byUsername.get());
        }else{
            logout();
        }
        return success;
    }

    private void login(UserEntity user){
        currentUser.setLogged(true)
                .setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout(){
        currentUser.clear();
    }

}
