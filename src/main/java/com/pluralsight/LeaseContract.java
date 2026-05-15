package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue, leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * 0.5;
        this.leaseFee =  vehicle.getPrice() * 0.07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return vehicle.getPrice() + this.leaseFee + this.expectedEndingValue;
    }
    @Override
    public double getMonthlyPayment() {
        double monthlyRate = 0.04 / 12;
        int months = 36;
        return (getTotalPrice() * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
