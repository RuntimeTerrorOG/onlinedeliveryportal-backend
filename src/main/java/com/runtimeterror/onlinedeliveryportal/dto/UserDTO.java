package com.runtimeterror.onlinedeliveryportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String email;
    private String name;
    private String pass;
}
