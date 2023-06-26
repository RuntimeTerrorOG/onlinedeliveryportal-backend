package com.runtimeterror.onlinedeliveryportal.service;

import com.runtimeterror.onlinedeliveryportal.dto.UserDTO;
import com.runtimeterror.onlinedeliveryportal.entity.User;
import com.runtimeterror.onlinedeliveryportal.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }

    //user id > user details
    // select * from user where id = 2
    public UserDTO getUserByUserID(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user,UserDTO.class);
    }

    //user id , address > user details
    //select * from user where id= 2 and address = "Kandy"
    public UserDTO getUserByUserIDAndPassword(String userId,String address){
        User user =userRepo.getUserByUserIDAndPassword(userId,address);
        return modelMapper.map(user,UserDTO.class);
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
