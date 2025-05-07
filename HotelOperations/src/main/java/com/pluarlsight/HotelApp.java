package com.pluarlsight;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Operations - Concise Tests ---");

        // --- Employee Tests ---
        Employee emp1 = new Employee(301, "Auto Clock", "HR", 25.00, 0.0);
        System.out.println("\nEmployee: " + emp1.toString());
        emp1.punchIn(); // Current time
        emp1.punchOut(); // Current time
        System.out.println("After auto shift: " + emp1.toString());

        emp1.punchIn(8.0); // Manual 8 AM
        emp1.punchOut(12.5); // Manual 12:30 PM (4.5 hrs)
        System.out.println("After manual shift: " + emp1.toString());


        // --- Hotel Tests ---
        Hotel grandHotel = new Hotel("The Grand", 10, 30);
        System.out.println("\nHotel: " + grandHotel.toString());

        grandHotel.bookRoom(2, true); // Book 2 suites
        grandHotel.bookRoom(5, false); // Book 5 basic rooms
        System.out.println("After bookings: " + grandHotel.toString());

        grandHotel.bookRoom(10, true); // Try to book too many suites
        System.out.println("After failed suite booking: " + grandHotel.toString());

        Hotel cozyInn = new Hotel("Cozy B&B", 3, 5, 1, 4); // Start with some booked
        System.out.println("\nNew Hotel: " + cozyInn.toString());
        cozyInn.bookRoom(2, true); // Book remaining 2 suites
        System.out.println("After Cozy Inn booking: " + cozyInn.toString());


        System.out.println("\n--- Tests Complete ---");
    }
}

