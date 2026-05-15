package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.isFinanced = isFinanced;
        this.salesTaxAmount = vehicle.getPrice() * 0.05;
        this.recordingFee = 100.00;
        if (vehicle.getPrice() >= 10000) {
            this.processingFee = 495;
        } else {
            this.processingFee = 295;
        }
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {
        return vehicle.getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) return 0;

        double monthlyRate;
        int months;

        if (vehicle.getPrice() >= 10000) {
            monthlyRate = 0.0425 / 12;
            months = 48;
        } else {
            monthlyRate = 0.0525 / 12;
            months = 24;
        }
        return (getTotalPrice() * monthlyRate) / (1-Math.pow(1 + monthlyRate, - months) );
    }
}
