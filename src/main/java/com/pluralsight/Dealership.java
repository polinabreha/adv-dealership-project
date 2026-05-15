package com.pluralsight;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private final ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList <Vehicle> getVehiclesByPrice (double min, double max){
        ArrayList <Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                vehicles.add(vehicle);
            }
        }
        if(vehicles.isEmpty()){
            System.out.println(Design.RED + "Is not found" + Design.RESET);
        }
        return vehicles;
    }
    public ArrayList <Vehicle> getVehiclesByMakeModel (String make,String model){
        ArrayList <Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }
        if(vehicles.isEmpty()){
            System.out.println(Design.RED + "Is not found"  + Design.RESET);
        }
        return vehicles;
    }

    public ArrayList <Vehicle> getVehiclesByYear (int min, int max){
        ArrayList <Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                vehicles.add(vehicle);
            }
        }
        if(vehicles.isEmpty()){
            System.out.println(Design.RED + "Is not found"   + Design.RESET);
        }
        return vehicles;
    }

    public ArrayList <Vehicle> getVehiclesByColor (String color){
        ArrayList <Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }
        }
        if(vehicles.isEmpty()){
            System.out.println(Design.RED + "Is not found"   + Design.RESET);
        }
        return vehicles;
    }

    public ArrayList <Vehicle> getVehiclesByMileage (int min, int max){
        ArrayList <Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                vehicles.add(vehicle);
            }
        }
        if(vehicles.isEmpty()){
            System.out.println(Design.RED + "Is not found"   + Design.RESET);
        }

        return vehicles;
    }

    public ArrayList <Vehicle> getVehiclesByType (String vehicleType){
        ArrayList <Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehicles.add(vehicle);
            }
        }
        if(vehicles.isEmpty() ){
            System.out.println(Design.RED + "Is not found"   + Design.RESET);
        }
        return vehicles;
    }

    public ArrayList <Vehicle> getAllVehicles (){
        return this.inventory;
    }

    public  void addVehicle (Vehicle vehicle){
        this.inventory.add(vehicle);

    }
    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);

    }

}
