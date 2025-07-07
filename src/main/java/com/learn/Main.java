package com.learn;


import com.learn.model.Customer;
import com.learn.model.LoanApplication;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        
         LoanApplication loanApplication = new LoanApplication.Builder()
                .setApplicationId(1)
                .setLoanAmount(50000.0)
                .setInterestRate(5.5)
                .setTenure(24)
                .setCreditScore(750.0f)
                .build();
        System.out.println(loanApplication);

        Customer customer = new Customer.Builder()
                .setCustomerId(101)
                .setCustomerName("John Doe")
                .setCustomerEmail("john.doe@example.com")
                .setCustomerPhone("123-456-7890")
                .setLoanApplication(loanApplication)
                .build();
        System.out.println(customer);

    }
}