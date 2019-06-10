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

    public void insertUser(RegistrationFormDTO registrationFormDTO) {

        User user = new User();
        user.setLogin(registrationFormDTO.getLogin());
        user.setPassword(registrationFormDTO.getPassword());
        user.setActive(true);
        user.setFirstName(registrationFormDTO.getFirstName());
        user.setLastName(registrationFormDTO.getLastName());

        userRepository.save(user);
        userRepository.setUserRole(user.getLogin());
    }

    public boolean isLoginTaken(String login) {

        try {
            User user = userRepository.getByLogin(login);
            user.getLogin();
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    public User getUser(String login) {
        return userRepository.getByLogin(login);
    }
}
