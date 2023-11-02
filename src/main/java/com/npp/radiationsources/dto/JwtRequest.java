package com.npp.radiationsources.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtRequest {
    private String name;
    public String password;
}
