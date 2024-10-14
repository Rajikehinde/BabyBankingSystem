package com.babyBankingSystem.accounts.mapper;

import com.babyBankingSystem.accounts.dto.AccountDto;
import com.babyBankingSystem.accounts.entity.Accounts;

public class AccountMapper {

    /**
     *
     * @param account -Transfer every value in account to accountDto
     * @param accountDto - receive every value from account to accountDto
     * @return
     */
    public static AccountDto mapToAccountDto(Accounts account, AccountDto accountDto){
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    /**
     *
     * @param accountDto - Transfer every value in accountDto to account
     * @param account - receive every value from accountDto to account
     * @return
     */
    public static Accounts mapToAccounts(AccountDto accountDto, Accounts account){
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
