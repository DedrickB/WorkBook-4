package com.pluarlsight;

public class HotelApp {



        public static void main(String[] args) {
            System.out.println("--- Hotel Operations Testing ---");

            // Create a room and print its details.
            System.out.println("\n--- Room Tests (Brief) ---");
            Room room1 = new Room(1, 180.00, false, false);
            System.out.println("Room 1: " + room1.toString());


            // Create a reservation and print its details.
            System.out.println("\n--- Reservation Tests (Brief) ---");
            Reservation resWeekday = new Reservation("king", 3, false);
            System.out.println("Weekday King Res: " + resWeekday.toString());


            // --- Test Employee Class ---
            System.out.println("\n\n--- Testing Employee Class ---");

            // Create different employees to test various scenarios.
            Employee empAlice = new Employee(101, "Alice Wonderland", "Housekeeping", 15.00, 35.0); // All regular hours
            Employee empBob = new Employee(102, "Bob The Builder", "Maintenance", 22.50, 45.5);   // Regular + Overtime
            Employee empCharlie = new Employee(103, "Charlie Chaplin", "Front Desk", 18.75, 40.0); // Exactly regular hours
            Employee empDiana = new Employee(104, "Diana Prince", "Management", 35.00, 0.0);       // No hours worked

            // Test what happens if we give negative numbers to the constructor.
            Employee empNegativeRate = new Employee(105, "Negative Nelly", "Billing", -10.00, 20.0); // Invalid pay rate
            Employee empNegativeHours = new Employee(106, "Zero Kelvin", "Research", 25.00, -5.0);  // Invalid hours

            // Print the initial details for each employee.
            System.out.println("\n--- Initial Employee Payroll ---");
            System.out.println(empAlice.toString()); // Show Alice's info
            System.out.println("\n" + empBob.toString()); // Show Bob's info
            System.out.println("\n" + empCharlie.toString()); // Show Charlie's info
            System.out.println("\n" + empDiana.toString()); // Show Diana's info
            System.out.println("\n" + empNegativeRate.toString()); // Nelly's pay rate should be 0
            System.out.println("\n" + empNegativeHours.toString()); // Kelvin's hours and pay should be 0

            // Change Alice's hours and pay rate, then check her pay again.
            System.out.println("\n\n--- Updating Alice's Information ---");
            System.out.println("Alice before update: Pay Rate $" + empAlice.getPayRate() +
                    ", Hours Worked: " + empAlice.getHoursWorked());
            empAlice.setHoursWorked(50); // Alice worked more hours
            empAlice.setPayRate(16.00);  // Alice got a raise
            System.out.println("Alice after update:");
            System.out.println(empAlice.toString()); // Show Alice's updated info and pay

            // Try to give Bob invalid numbers for pay rate and hours.
            System.out.println("\n\n--- Testing Invalid Setters for Bob ---");
            System.out.println("Bob before attempting invalid sets: Rate $" + empBob.getPayRate() +
                    ", Hours: " + empBob.getHoursWorked() + ", Total Pay: $" + String.format("%.2f", empBob.getTotalPay()));
            empBob.setPayRate(-5.0); // Try to set a negative pay rate
            empBob.setHoursWorked(-10.0); // Try to set negative hours
            System.out.println("Bob after attempting invalid sets (should be unchanged):");
            System.out.println(empBob.toString()); // Bob's info should not have changed

            System.out.println("\n\n--- Testing Complete ---");
        }
    }
