package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv", true));
            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                bw.write("\nSALE|" + sc.getDateOfContract() + "|" +
                                       sc.getCustomerName() +   "|" +
                                       sc.getCustomerEmail() +  "|" +
                                       sc.getVehicle().getVin() +  "|" +
                                       sc.getVehicle().getYear() + "|" +
                                       sc.getVehicle().getMake() + "|" +
                                       sc.getVehicle().getModel() +"|" +
                                       sc.getVehicle().getVehicleType() + "|" +
                                       sc.getVehicle().getColor() +  "|" +
                                       sc.getVehicle().getOdometer() +  "|" +
                                       sc.getVehicle().getPrice() +  "|" +
                                       sc.getSalesTaxAmount() +  "|" +
                                       sc.getRecordingFee() +  "|" +
                                       sc.getProcessingFee() + "|" +
                                       sc.getTotalPrice() +  "|" +
                                       sc.isFinanced() +  "|" +
                                       sc.getMonthlyPayment());
            }else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                bw.write("\nLEASE|" + lc.getDateOfContract() + "|" +
                                        lc.getCustomerName() +   "|" +
                                        lc.getCustomerEmail() +  "|" +
                                        lc.getVehicle().getVin() +  "|" +
                                        lc.getVehicle().getYear() + "|" +
                                        lc.getVehicle().getMake() + "|" +
                                        lc.getVehicle().getModel() +"|" +
                                        lc.getVehicle().getVehicleType() + "|" +
                                        lc.getVehicle().getColor() +  "|" +
                                        lc.getVehicle().getOdometer() +  "|" +
                                        lc.getVehicle().getPrice() +  "|" +
                                        lc.getExpectedEndingValue() +  "|" +
                                        lc.getLeaseFee()+  "|" +
                                        lc.getTotalPrice() +  "|" +
                                        lc.getMonthlyPayment());
            }
            bw.newLine();
            bw.close();
        }catch (IOException e){
            System.out.println("Error saving contract" + e.getMessage());
        }
    }
}
