package com.learn.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.learn.model.Customer;
import com.learn.model.LoanApplication;


public class LoanApprovalServiceTest {

    @Test
    void testApproveLoanApplication() {
        // Test with a valid customer and loan application
        LoanApplication loanApplication = new LoanApplication.Builder()
                .setApplicationId(1)
                .setCreditScore(5.0f)
                .setLoanAmount(200000.0)
                .setTenure(7)
                .setInterestRate(4.5)
                .build();

        Customer customer = new Customer.Builder()
                .setCustomerId(101)
                .setCustomerName("Test Customer")
                .setCustomerEmail("test@example.com")
                .setCustomerPhone("123-456-7890")
                .setLoanApplication(loanApplication)
                .setAge(35)
                .build();

        LoanApprovalService service = LoanApprovalService.getInstance();
        assertTrue(service.approveLoanApplication(customer));
    }

    @Test
    void testGetInstance() {
        // Test singleton pattern - multiple calls should return same instance
        LoanApprovalService service1 = LoanApprovalService.getInstance();
        LoanApprovalService service2 = LoanApprovalService.getInstance();
        
        assertNotNull(service1);
        assertNotNull(service2);
        assertSame(service1, service2);
    }

    @Test
    void testApproveLoanApplication_AllValid() {
        // create the loanApplication object with valid parameters using builder pattern
        LoanApplication loanApplication = new LoanApplication.Builder()
                .setApplicationId(1)
                .setCreditScore(5.0f)
                .setLoanAmount(300000.0)
                .setTenure(5)
                .setInterestRate(5.5)
                .build();

        //create the customer object with valid parameters using builder pattern
        Customer customer = new Customer.Builder()
                .setCustomerId(101)
                .setCustomerName("John Doe")
                .setCustomerEmail("john.doe@example.com")
                .setCustomerPhone("123-456-7890")
                .setLoanApplication(loanApplication)
                .setAge(30)
                .build();


        LoanApprovalService service = LoanApprovalService.getInstance();
        assertTrue(service.approveLoanApplication(customer));
    }

    @Test
    void testApproveLoanApplication_NullCustomer() {
        LoanApprovalService service = LoanApprovalService.getInstance();
        assertFalse(service.approveLoanApplication(null));
    }

        

    @Test
    void testApproveLoanApplication_NullLoanApplication() {
         // create a customer with null loan application using builder pattern
        Customer customer = new Customer.Builder()
                .setAge(30)
                .setLoanApplication(null)
                .build();


        LoanApprovalService service = LoanApprovalService.getInstance();
        assertFalse(service.approveLoanApplication(customer));
    }

    @Test
    void testApproveLoanApplication_InvalidAge() {
        LoanApplication loanApplication = new LoanApplication.Builder()
            .setCreditScore(5.0f)
            .setLoanAmount(300000.0)
            .setTenure(5)
            .build();
        Customer customer = new Customer.Builder()
            .setAge(17) // too young
            .setLoanApplication(loanApplication)
            .build();

        LoanApprovalService service = LoanApprovalService.getInstance();
        assertFalse(service.approveLoanApplication(customer));

        
    }

    @Test
    void testApproveLoanApplication_InvalidCreditScore() {
        LoanApplication loanApplication = new LoanApplication.Builder()
            .setCreditScore(4.0f) // not above 4.0
            .setLoanAmount(300000.0)
            .setTenure(5)
            .build();

        Customer customer = new Customer.Builder()
            .setAge(30)
            .setLoanApplication(loanApplication)
            .build();

        LoanApprovalService service = LoanApprovalService.getInstance();
        assertFalse(service.approveLoanApplication(customer));
    }

    @Test
    void testApproveLoanApplication_InvalidLoanAmount() {
        LoanApplication loanApplication = new LoanApplication.Builder()
            .setCreditScore(5.0f)
            .setLoanAmount(600000.0) // exceeds limit
            .setTenure(5)
            .build();

        Customer customer = new Customer.Builder()
            .setAge(30)
            .setLoanApplication(loanApplication)
            .build();

        LoanApprovalService service = LoanApprovalService.getInstance();
        assertFalse(service.approveLoanApplication(customer));
    }

    @Test
    void testApproveLoanApplication_InvalidTenure() {
        LoanApplication loanApplication = new LoanApplication.Builder()
            .setCreditScore(5.0f)
            .setLoanAmount(300000.0)
            .setTenure(10) // tenure is not less than 10
            .build();

        Customer customer = new Customer.Builder()
            .setAge(30)
            .setLoanApplication(loanApplication)
            .build();

        LoanApprovalService service = LoanApprovalService.getInstance();
        assertFalse(service.approveLoanApplication(customer));
    }


@Test
void testApproveLoanApplication_EdgeCaseAge18() {
    LoanApplication loanApplication = new LoanApplication.Builder()
        .setCreditScore(5.0f)
        .setLoanAmount(100000.0)
        .setTenure(5)
        .build();

    Customer customer = new Customer.Builder()
        .setAge(18)
        .setLoanApplication(loanApplication)
        .build();

    LoanApprovalService service = LoanApprovalService.getInstance();
    assertTrue(service.approveLoanApplication(customer));
}

@Test
void testApproveLoanApplication_EdgeCaseAge65() {
    LoanApplication loanApplication = new LoanApplication.Builder()
        .setCreditScore(5.0f)
        .setLoanAmount(100000.0)
        .setTenure(5)
        .build();

    Customer customer = new Customer.Builder()
        .setAge(65)
        .setLoanApplication(loanApplication)
        .build();

    LoanApprovalService service = LoanApprovalService.getInstance();
    assertTrue(service.approveLoanApplication(customer));
}

@Test
void testApproveLoanApplication_EdgeCaseLoanAmount500000() {
    LoanApplication loanApplication = new LoanApplication.Builder()
        .setCreditScore(5.0f)
        .setLoanAmount(500000.0)
        .setTenure(5)
        .build();

    Customer customer = new Customer.Builder()
        .setAge(30)
        .setLoanApplication(loanApplication)
        .build();

    LoanApprovalService service = LoanApprovalService.getInstance();
    assertTrue(service.approveLoanApplication(customer));
}

@Test
void testApproveLoanApplication_EdgeCaseCreditScoreJustAbove() {
    LoanApplication loanApplication = new LoanApplication.Builder()
        .setCreditScore(4.1f)
        .setLoanAmount(100000.0)
        .setTenure(5)
        .build();

    Customer customer = new Customer.Builder()
        .setAge(30)
        .setLoanApplication(loanApplication)
        .build();

    LoanApprovalService service = LoanApprovalService.getInstance();
    assertTrue(service.approveLoanApplication(customer));
}

@Test
void testApproveLoanApplication_EdgeCaseTenure9() {
    LoanApplication loanApplication = new LoanApplication.Builder()
        .setCreditScore(5.0f)
        .setLoanAmount(100000.0)
        .setTenure(9)
        .build();

    Customer customer = new Customer.Builder()
        .setAge(65)
        .setLoanApplication(loanApplication)
        .build();

    LoanApprovalService service = LoanApprovalService.getInstance();
    assertTrue(service.approveLoanApplication(customer));
}




@Test
void testApproveLoanApplication_AllInvalid() {
    LoanApplication loanApplication = new LoanApplication.Builder()
        .setCreditScore(3.0f) // invalid credit score
        .setLoanAmount(600000.0) // invalid loan amount
        .setTenure(15) // invalid tenure
        .build();

    Customer customer = new Customer.Builder()
        .setAge(70) // invalid age
        .setLoanApplication(loanApplication)
        .build();

    LoanApprovalService service = LoanApprovalService.getInstance();
    assertFalse(service.approveLoanApplication(customer));
}
}

