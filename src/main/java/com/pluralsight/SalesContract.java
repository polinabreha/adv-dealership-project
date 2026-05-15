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
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
