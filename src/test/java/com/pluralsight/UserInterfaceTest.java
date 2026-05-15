package com.pluralsight;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    @Test
    public void testVehicleSoldGetsRemoved() throws Exception {

        // Arrange
        Dealership dealership = new Dealership("Paul", "Pittsburgh", "63472672");

        Vehicle vehicle = new Vehicle(
                12345,
                2024,
                "Toyota",
                "Camry",
                "Sedan",
                "Blue",
                10000,
                25000
        );

        dealership.addVehicle(vehicle);

        UserInterface ui = new UserInterface();

        // inject dealership using reflection
        Field field = UserInterface.class.getDeclaredField("dealership");
        field.setAccessible(true);
        field.set(ui, dealership);

        String simulatedInput =
                "12345\n" +
                        "Polina\n" +
                        "test@test.com\n" +
                        "2026-05-15\n" +
                        "S\n" +
                        "yes\n";

        ui.scanner = new Scanner(simulatedInput);

        // Act
        ui.processSellLeaseVehicleRequest();

        // Assert
        assertFalse(dealership.getAllVehicles().contains(vehicle));
    }

}