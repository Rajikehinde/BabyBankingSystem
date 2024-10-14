package com.babyBankingSystem.accounts.service;

import com.babyBankingSystem.accounts.constant.AccountsConstants;
import com.babyBankingSystem.accounts.dto.AccountDto;
import com.babyBankingSystem.accounts.dto.CustomerDto;
import com.babyBankingSystem.accounts.entity.Accounts;
import com.babyBankingSystem.accounts.entity.Customer;
import com.babyBankingSystem.accounts.exception.CustomerAlreadyExistsException;
import com.babyBankingSystem.accounts.exception.ResourceNotFoundException;
import com.babyBankingSystem.accounts.mapper.AccountMapper;
import com.babyBankingSystem.accounts.mapper.CustomerMapper;
import com.babyBankingSystem.accounts.repository.AccountRepository;
import com.babyBankingSystem.accounts.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountService{

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    +customerDto.getMobileNumber());
        }
        customer.setCreatedBy("Anonymous");
        customer.setCreatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);

        accountRepository.save(createNewAccount(savedCustomer));
    }

    /**
     *
     * @param mobileNumber
     * @return
     */

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer =customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts =accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountDto(accounts, new AccountDto()));
        return customerDto;
    }

    /**
     *
     * @param customerDto
     * @return
     */

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountDto = customerDto.getAccountDto();
        if (accountDto != null){
            Accounts accounts = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "accountNumber", accountDto.getAccountNumber().toString())
            );
            /**
             * Transfer all data(value) in accountDto to account
             */
        AccountMapper.mapToAccounts(accountDto, accounts);
        accounts = accountRepository.save(accounts);

        Long customerId = accounts.getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer","CustomerId", customerId.toString())
        );
            /**
             * Transfer all the updated data from customerDto to customer
             */
        CustomerMapper.mapToCustomer(customerDto, customer);
        customerRepository.save(customer);
        isUpdated = true;
        }
        return isUpdated;
    }

    /**
     *
     * @param mobileNumber
     * @return
     */

    @Override
    public boolean deleteNumber(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    /**
     *
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(90000000);

        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        customer.setCreatedBy("Anonymous");
        customer.setCreatedAt(LocalDateTime.now());
        return newAccount;
    }
}
