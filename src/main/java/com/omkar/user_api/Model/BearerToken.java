package com.omkar.user_api.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BearerToken {
    private String jwt_token;
}
