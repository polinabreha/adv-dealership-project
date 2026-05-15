package com.pluralsight;

public abstract class Contract {
    protected String dateOfContract, customerName, customerEmail;
    protected Vehicle vehicle;

    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
