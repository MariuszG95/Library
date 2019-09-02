package core.services;

import data.model.User;
import data.repositories.UserRepository;
import dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public boolean isLoginTaken(String login) {
        try {
            userRepository.getUserByLogin(login);
            return true;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    public void addNewUser(RegistrationFormDTO registrationFormDTO) {
        User user = new User();
        user.setLogin(registrationFormDTO.getLogin());
        user.setEmail(registrationFormDTO.getEmail());
        user.setPassword(registrationFormDTO.getPassword());
        user.setActive(true);

        userRepository.save(user);
        userRepository.setUserRole(user.getLogin());
    }
}
