package com.learn.model;


/*
 * Customer class with fields  customerId as int,
 * customerName as String, customerEmail as String,
 * customerPhone as String,LoanApplication as LoanApplication.
 * Use Builder design pattern to create Customer object.
 */

public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private int age;
    private LoanApplication loanApplication;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.customerEmail = builder.customerEmail;
        this.customerPhone = builder.customerPhone;
        this.loanApplication = builder.loanApplication;
        this.age = builder.age;
    }

    // Getter methods
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }
    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", loanApplication=" + loanApplication +
                '}';
    }

    // Static inner Builder class
    public static class Builder {
        private int customerId;
        private String customerName;
        private String customerEmail;
        private String customerPhone;
        private LoanApplication loanApplication;
        private int age;

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
            return this;
        }

        public Builder setLoanApplication(LoanApplication loanApplication) {
            this.loanApplication = loanApplication;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}


