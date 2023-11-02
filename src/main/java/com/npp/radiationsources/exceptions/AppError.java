package com.npp.radiationsources.exceptions;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppError {
    private String code;
    private String message;
}
