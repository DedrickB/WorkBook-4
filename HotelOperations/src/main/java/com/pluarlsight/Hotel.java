package com.pluarlsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0, 0); // Call the other constructor
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = Math.max(0, numberOfSuites);
        this.numberOfRooms = Math.max(0, numberOfRooms);
        this.bookedSuites = Math.max(0, Math.min(bookedSuites, this.numberOfSuites));
        this.bookedBasicRooms = Math.max(0, Math.min(bookedBasicRooms, this.numberOfRooms));
    }

    // Getters
    public String getName() { return name; }
    public int getTotalSuites() { return numberOfSuites; }
    public int getTotalBasicRooms() { return numberOfRooms; }
    public int getBookedSuites() { return bookedSuites; }
    public int getBookedBasicRooms() { return bookedBasicRooms; }

    // Derived Availability Getters
    public int getAvailableSuites() { return this.numberOfSuites - this.bookedSuites; }
    public int getAvailableRooms() { return this.numberOfRooms - this.bookedBasicRooms; }

    public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite) {
        if (numberOfRoomsToBook <= 0) return false;

        if (isSuite) {
            if (getAvailableSuites() >= numberOfRoomsToBook) {
                this.bookedSuites += numberOfRoomsToBook;
                System.out.println("Booked " + numberOfRoomsToBook + " suite(s) at " + name + ".");
                return true;
            }
        } else {
            if (getAvailableRooms() >= numberOfRoomsToBook) {
                this.bookedBasicRooms += numberOfRoomsToBook;
                System.out.println("Booked " + numberOfRoomsToBook + " basic room(s) at " + name + ".");
                return true;
            }
        }
        System.out.println("Booking failed for " + (isSuite ? "suites" : "basic rooms") + " at " + name + ".");
        return false;
    }

    @Override
    public String toString() {
        return String.format("Hotel '%s': Suites Avail: %d/%d, Basic Avail: %d/%d",
                name, getAvailableSuites(), numberOfSuites, getAvailableRooms(), numberOfRooms);
    }
}