package com.babyBankingSystem.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by client"
    )
    private String apiPath;  //api failure reason(The api causing err)

    @Schema(
            description = "Error code representing the error happened"
    )
    private HttpStatus errorCode; // errorCode failure reason

    @Schema(
            description = "Error message representing the error happened"
    )
    private String errorMessage; // error message

    @Schema(
            description = "Time representing when the error happened"
    )
    private LocalDateTime errorTime; //Time of error
}
