package com.babyBankingSystem.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {

    @Pattern(regexp = "(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @NotEmpty(message = "AccountNumber can not be nu;ll or empty")
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be null or empty")
    private String branchAddress;
}
