package com.pluralsight;
import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        String line;

        String firstLine = bufferedReader.readLine();
        String[] dealershipInfo = firstLine.split("\\|");
        Dealership dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);

        while ((line = bufferedReader.readLine()) != null) {
            String[] cells = line.split("\\|");
            Vehicle vehicle = new Vehicle(Integer.parseInt(cells[0]), Integer.parseInt(cells[1]),
                    cells[2], cells [3], cells[4], cells[5],Integer.parseInt(cells[6]), Double.parseDouble(cells[7]));
            dealership.addVehicle(vehicle);
        }
        bufferedReader.close();
        return dealership;
    }

    public void saveDealership(Dealership dealership) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"));
        bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
        bufferedWriter.newLine();
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            bufferedWriter.write(vehicle.getVin()  + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|"
                    +vehicle.getOdometer() + "|" +  vehicle.getPrice() );
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

    }


}
