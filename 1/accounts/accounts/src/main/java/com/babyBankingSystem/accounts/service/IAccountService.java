package com.babyBankingSystem.accounts.service;

import com.babyBankingSystem.accounts.dto.CustomerDto;

public interface IAccountService {


    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
