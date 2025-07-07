package com.learn.model;



/*
 *  class with applicationId as int, loanAmount as double,
 *  interestRate as double, tenure as  int
 *  creditScore as  float . Use Builder design pattern
 *  create  static inner class builder to build LoanApplication object.
 * 
 *  */
public class LoanApplication {
    private int applicationId;
    private double loanAmount;
    private double interestRate;
    private int tenure;
    private float creditScore;

    private LoanApplication(Builder builder) {
        this.applicationId = builder.applicationId;
        this.loanAmount = builder.loanAmount;
        this.interestRate = builder.interestRate;
        this.tenure = builder.tenure;
        this.creditScore = builder.creditScore;
    }

    //getter  method

    public int getApplicationId() {
        return applicationId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public int getTenure() {
        return tenure;
    }

    public float getCreditScore() {
        return creditScore;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "applicationId=" + applicationId +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", tenure=" + tenure +
                ", creditScore=" + creditScore +
                '}';
    }



    public static class Builder {
        private int applicationId;
        private double loanAmount;
        private double interestRate;
        private int tenure;
        private float creditScore;

        public Builder setApplicationId(int applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public Builder setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
            return this;
        }

        public Builder setInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder setTenure(int tenure) {
            this.tenure = tenure;
            return this;
        }

        public Builder setCreditScore(float creditScore) {
            this.creditScore = creditScore;
            return this;
        }

        public LoanApplication build() {
            return new LoanApplication(this);
        }
    }
}

