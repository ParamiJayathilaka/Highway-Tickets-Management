package com.example.user_services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {

    private String id;
    private String name;
    private String password;
}
