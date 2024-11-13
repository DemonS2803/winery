package ru.spmi.winery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

    private String login;
    private String password;
    private String authority;
    private String token;

}
