package com.babyBankingSystem.accounts.service;

import com.babyBankingSystem.accounts.dto.CustomerDto;

public interface IAccountService {


    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteNumber(String mobileNumber);
}
