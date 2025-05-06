package com.pluarlsight;


public class Room {

    // Backing Variables: Store the fundamental state of the room
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;


    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    // Standard Getters: Provide access to backing variables
    public int getNumberOfBeds() { return numberOfBeds; }
    public double getPrice() { return price; }
    public boolean isOccupied() { return occupied; }
    public boolean isDirty() { return dirty; }


    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // Optional: Setters to modify room state after creation
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
    public void setDirty(boolean dirty) { this.dirty = dirty; }

    @Override
    public String toString() {
        return String.format("Room[Beds: %d, Price: $%.2f, Occupied: %b, Dirty: %b, Available: %b]",
                numberOfBeds, price, occupied, dirty, isAvailable());
    }
}