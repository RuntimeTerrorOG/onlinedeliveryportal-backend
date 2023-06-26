package RuntimeTerror.OnlineDeliveryPortalLoginSignup.security.services;

import RuntimeTerror.OnlineDeliveryPortalLoginSignup.dto.UserDTO;
import RuntimeTerror.OnlineDeliveryPortalLoginSignup.models.User;
import RuntimeTerror.OnlineDeliveryPortalLoginSignup.repository.UserRepository;
import RuntimeTerror.OnlineDeliveryPortalLoginSignup.security.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

@Service
@Transactional
public class UserServices {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("Could not find any customer with the email " + email);
        }
    }

    public User getByResetPasswordToken(String token) {
        return userRepo.findByResetPasswordToken(token);
    }

    public UserDTO updatePassword(String email, String username, String newPassword) {
        User user = userRepo.findByEmailAndUsername(email, username); // Change the method name from "findByEmailAndName" to "findByEmailAndUsername"
        if (user != null) {
            String encodedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }



}
