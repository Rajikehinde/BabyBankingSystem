package com.babyBankingSystem.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountDto {

    @Pattern(regexp = "(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @NotEmpty(message = "AccountNumber can not be null or empty")
    @Schema(
            description = "Account Number ",example = "9487362903"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be null or empty")
    @Schema(
            description = "Account type of BabyBanking ", example = "savings"
    )
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be null or empty")
    @Schema(
            description = "Address", example = "839, Mainland"
    )
    private String branchAddress;
}
