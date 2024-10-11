package com.babyBankingSystem.accounts.mapper;

import com.babyBankingSystem.accounts.dto.AccountDto;
import com.babyBankingSystem.accounts.entity.Accounts;

public class AccountMapper {

    public AccountDto mapToAccountDto(Accounts account, AccountDto accountDto){
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Accounts mapToAccounts(AccountDto accountDto, Accounts account){
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
