package com.pluarlsight;


// Manages a hotel room's status
public class Room {

    // Room details
    private int numberOfBeds;
    private double price;
    private boolean occupied; // Is someone in it?
    private boolean dirty;    // Does it need cleaning?

    // Constructor - sets up a new room
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    // Getters - to see room info
    public int getNumberOfBeds() { return numberOfBeds; }
    public double getPrice() { return price; }
    public boolean isOccupied() { return occupied; }
    public boolean isDirty() { return dirty; }

    // Is the room free and clean?
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // --- New Room Actions ---

    // Guest checks in
    public void checkIn() {
        if (isAvailable()) { // Only if it's ready
            this.occupied = true;
            this.dirty = true; // Room gets dirty when used
            System.out.println("Room checked in. Now occupied and dirty.");
        } else {
            System.out.println("Cannot check in. Room not available.");
        }
    }

    // Guest checks out
    public void checkOut() {
        if (this.occupied) { // Only if someone is in it
            this.occupied = false;
            // Stays dirty until cleaned
            System.out.println("Room checked out. Now empty, needs cleaning.");
        } else {
            System.out.println("Cannot check out. Room already empty.");
        }
    }

    // Housekeeping cleans the room
    public void cleanRoom() {
        if (this.occupied) { // Can't clean if guest is still there
            System.out.println("Cannot clean. Room is occupied.");
            return;
        }
        if (this.dirty) { // Only if it's actually dirty
            this.dirty = false;
            System.out.println("Room cleaned. Ready for next guest.");
        } else {
            System.out.println("Room already clean or doesn't need cleaning.");
        }
    }

    // For printing room status
    @Override
    public String toString() {
        return String.format("Room[Beds: %d, Price: $%.2f, Occupied: %b, Dirty: %b, Available: %b]",
                numberOfBeds, price, occupied, dirty, isAvailable());
    }
}