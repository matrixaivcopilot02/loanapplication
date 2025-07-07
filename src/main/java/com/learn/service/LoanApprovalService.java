package com.learn.service;
import com.learn.model.Customer;
import com.learn.model.LoanApplication;


/*
 *  create a class with methoad  approveLoanApplication and pass Customer as a parameter
 * and return boolean value.
 * class must use a singleton design pattern.
 * Approve the loan application if the customer's credit score is
 *  above 4.0 and the  loan amount is less than or equal to 500000
 * and tenure  is less than 10 years.
 */


 

public class LoanApprovalService {
    private static LoanApprovalService instance;

    private LoanApprovalService() {
    }

    public static synchronized LoanApprovalService getInstance() {
        if (instance == null) {
            instance = new LoanApprovalService();
        }
        return instance;
    }
    // inline chat - make  conditions single, make code more readble, make code more robust

    /**
     * Evaluates and approves a loan application for a given customer based on predefined criteria.
     *
     * <p>The method checks the following conditions:
     * <ul>
     *   <li>The customer and their loan application must not be {@code null}.</li>
     *   <li>The customer's age must be between 18 and 65 (inclusive).</li>
     *   <li>The loan application's credit score must be greater than 4.0.</li>
     *   <li>The requested loan amount must not exceed 500,000.</li>
     *   <li>The loan tenure must be less than 10 years.</li>
     * </ul>
     * If all conditions are met, the loan application is approved.
     *
     * @param customer the customer applying for the loan
     * @return {@code true} if the loan application is approved; {@code false} otherwise
     */
    public boolean approveLoanApplication(Customer customer) {
        if (customer == null || customer.getLoanApplication() == null) {
            return false;
        }

        LoanApplication loanApplication = customer.getLoanApplication();

        // Validate age
        Integer age = customer.getAge();
        if (age == null || age < 18 || age > 65) {
            return false;
        }

        // Validate credit score
        Double creditScore = (double) loanApplication.getCreditScore();
        if (creditScore == null || creditScore <= 4.0) {
            return false;
        }

        // Validate loan amount
        Double loanAmount = loanApplication.getLoanAmount();
        if (loanAmount == null || loanAmount > 500000) {
            return false;
        }

        // Validate tenure
        Integer tenure = loanApplication.getTenure();
        if (tenure == null || tenure >= 10) {
            return false;
        }

        return true;
    }
}
