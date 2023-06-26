package RuntimeTerror.OnlineDeliveryPortalLoginSignup.controllers;


import RuntimeTerror.OnlineDeliveryPortalLoginSignup.dto.UserDTO;
import RuntimeTerror.OnlineDeliveryPortalLoginSignup.security.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServices userService;

    @PutMapping("/updatePassword")
    public UserDTO updatePassword(@RequestBody UserDTO userDTO) {
        return userService.updatePassword(userDTO.getEmail(), userDTO.getUsername(), userDTO.getPassword());
    }
}
