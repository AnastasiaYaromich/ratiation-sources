package com.npp.radiationsources.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtRequestDto {
    private String username;
    public String password;
}
