package com.pluralsight;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    static final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    private  void init (){
        try {
            DealershipFileManager dealershipFileManager = new DealershipFileManager();
            this.dealership = dealershipFileManager.getDealership();
        }catch (IOException  e){
            System.out.println(Design.RED+ "Error" + e.getMessage() + Design.RESET) ;
        }
    }
    public void display () throws IOException {
        init();
        boolean exit = true;
        greeting();
        while (exit) {
            System.out.println(Design.PURPLE + "Choose from the following options:" + Design.RESET);
            System.out.println(Design.CYAN +"1 - Find vehicles within a price range\n" +
                    "2 - Find vehicles by make / model\n" +
                    "3 - Find vehicles by year range\n" +
                    "4 - Find vehicles by color\n" +
                    "5 - Find vehicles by mileage range\n" +
                    "6 - Find vehicles by type (truck, SUV, van)\n" +
                    "7 - List ALL vehicles\n" +
                    "8 - Add a vehicle\n" +
                    "9 - Remove a vehicle\n" +
                    "99 - Quit");
            System.out.print("Enter your choice: " + Design.RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    exit = false;
                    end();
                    break;
                default:
                    System.out.println(Design.RED + "Wrong choice" + Design.RESET);
            }

        }

    }

    public void processGetByPriceRequest(){
        System.out.print(Design.PURPLE + "Please enter the minimum price: " + Design.RESET);
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print(Design.PURPLE +"Please enter the maximum price: " + Design.RESET);
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        ArrayList<Vehicle> results = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(results);
    }
    public void processGetByMakeModelRequest(){
        System.out.print(Design.PURPLE +"Please enter the make of the model: " + Design.RESET);
        String makeModel = scanner.nextLine();
        System.out.print(Design.PURPLE + "Please enter the model: "  + Design.RESET);
        String model = scanner.nextLine();
        ArrayList <Vehicle> results = dealership.getVehiclesByMakeModel(makeModel, model);
        displayVehicles(results);
    }
    public void processGetByYearRequest(){
        System.out.print(Design.PURPLE + "Please enter the minimum year range: "  + Design.RESET);
        int minYearRange = scanner.nextInt();
        scanner.nextLine();
        System.out.print(Design.PURPLE + "Please enter the maximum year range: " + Design.RESET);
        int maxYearRange = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> result = dealership.getVehiclesByYear(minYearRange, maxYearRange);
        displayVehicles(result);
    }
    public void processGetByColorRequest(){
        System.out.print(Design.PURPLE + "Please enter the color: " + Design.RESET);
        String color = scanner.nextLine();
        ArrayList <Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }
    public void processGetByMileageRequest(){
        System.out.print(Design.PURPLE + "Please enter the minimum mileage range: " + Design.RESET);
        int minMileageRange = scanner.nextInt();
        scanner.nextLine();
        System.out.print(Design.PURPLE + "Please enter the maximum mileage range: "  + Design.RESET);
        int maxMileageRange = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> result = dealership.getVehiclesByMileage(minMileageRange, maxMileageRange);
        displayVehicles(result);
    }
    public void processGetByVehicleTypeRequest(){
        System.out.print(Design.PURPLE + "Please enter the vehicle type: "  + Design.RESET);
        String vehicleType = scanner.nextLine();
        ArrayList<Vehicle> result =  dealership.getVehiclesByType(vehicleType);
        displayVehicles(result);
    }
    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest() {
        try {
            System.out.print(Design.PURPLE + "Enter vehicle vin: "  + Design.RESET);
            int vin = scanner.nextInt();
            scanner.nextLine();
            System.out.print(Design.PURPLE + "Enter the vehicle year: " + Design.RESET);
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print(Design.PURPLE + "Please enter the vehicle make: " + Design.RESET);
            String make = scanner.nextLine();
            System.out.print(Design.PURPLE + "Please enter the vehicle model: "  + Design.RESET);
            String model = scanner.nextLine();
            System.out.print(Design.PURPLE + "Enter the vehicle type: "  + Design.RESET);
            String vehicleType = scanner.nextLine();
            System.out.print(Design.PURPLE + "Please enter the vehicle color: "   + Design.RESET);
            String color = scanner.nextLine();
            System.out.print(Design.PURPLE + "Please enter the vehicle odometer: " + Design.RESET);
            int odometer = scanner.nextInt();
            scanner.nextLine();
            System.out.print(Design.PURPLE + "Please enter the vehicle price " + Design.RESET);
            double price = scanner.nextDouble();
            scanner.nextLine();

            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            DealershipFileManager fileManager = new DealershipFileManager();
            dealership.addVehicle(newVehicle);
            fileManager.saveDealership(dealership);
            System.out.println(Design.PURPLE + "Vehicle added successfully" + Design.RESET);
        }catch (IOException e){
            System.out.println(Design.RED+ "Error" + e.getMessage() + Design.RESET);
        }

    }
    public void processRemoveVehicleRequest() {
        try {
            System.out.print(Design.PURPLE + "Please enter the vehicle vin: "  + Design.RESET);
            int vin = scanner.nextInt();
            scanner.nextLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                if (vehicle.getVin() == vin) {
                    dealership.removeVehicle(vehicle);
                    break;
                }
            }
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
            System.out.println(Design.PURPLE + "Successfully removed vehicle"  + Design.RESET);
        }catch (IOException e){
            System.out.println(Design.RED + "Error" + e.getMessage()  + Design.RESET);
        }
    }

    public static void greeting(){
        System.out.println(Design.PURPLE_BACKGROUND +"|---------------------------------------------------------|" + Design.RESET);
        System.out.println(Design.PURPLE_BACKGROUND +"|        Welcome to Dealership Management System          |" + Design.RESET);
        System.out.println(Design.PURPLE_BACKGROUND +"|---------------------------------------------------------|" + Design.RESET);
    }

    public static void end(){
        System.out.println(Design.PURPLE_BACKGROUND +"|---------------------------------------------------------|" + Design.RESET);
        System.out.println(Design.PURPLE_BACKGROUND +"|           Thank You for visiting us today               |" + Design.RESET);
        System.out.println(Design.PURPLE_BACKGROUND +"|---------------------------------------------------------|" + Design.RESET);
    }

}
