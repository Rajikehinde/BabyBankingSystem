package com.babyBankingSystem.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;  //api failure reason(The api causing err)

    private HttpStatus errorCode; // errorCode failure reason

    private String errorMessage; // error message

    private LocalDateTime errorTime; //Time of error
}
