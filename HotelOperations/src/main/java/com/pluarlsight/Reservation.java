package com.pluarlsight;


public class Reservation {

    // Constants for pricing logic
    private static final double KING_BASE_PRICE = 139.00;
    private static final double DOUBLE_BASE_PRICE = 124.00;
    private static final double WEEKEND_SURCHARGE_MULTIPLIER = 1.10; // 10% increase

    // Backing Variables: Store the core reservation details
    private String roomType;    // "king" or "double"
    private int numberOfNights;
    private boolean weekend;    // true if stay includes a weekend


    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        setRoomType(roomType); // Use setter for validation
        setNumberOfNights(numberOfNights); // Use setter for validation
        this.weekend = weekend;
    }

    // Getters and Setters for backing variables
    public String getRoomType() { return roomType; }

    public void setRoomType(String roomType) {
        if (roomType != null && (roomType.equalsIgnoreCase("king") || roomType.equalsIgnoreCase("double"))) {
            this.roomType = roomType.toLowerCase();
        } else {
            if (this.roomType == null) { // Default if invalid during construction
                this.roomType = "double";
                System.err.println("Warning: Invalid initial room type. Defaulted to 'double'.");
            } else {
                System.err.println("Error: Invalid room type '" + roomType + "'. Not changed.");
            }
        }
    }

    public int getNumberOfNights() { return numberOfNights; }

    public void setNumberOfNights(int numberOfNights) {
        if (numberOfNights > 0) {
            this.numberOfNights = numberOfNights;
        } else {
            if (this.numberOfNights == 0) { // Default if invalid during construction
                this.numberOfNights = 1;
                System.err.println("Warning: Invalid initial number of nights. Defaulted to 1.");
            } else {
                System.err.println("Error: Number of nights must be positive. Not changed.");
            }
        }
    }

    public boolean isWeekend() { return weekend; }
    public void setIsWeekend(boolean weekend) { this.weekend = weekend; }


    public double getPrice() {
        double basePrice = "king".equals(this.roomType) ? KING_BASE_PRICE : DOUBLE_BASE_PRICE;
        return this.weekend ? basePrice * WEEKEND_SURCHARGE_MULTIPLIER : basePrice;
    }


    public double getReservationTotal() {
        return getPrice() * this.numberOfNights;
    }

    @Override
    public String toString() {
        return String.format("Reservation[Type: %s, Nights: %d, Weekend: %b, Price/Night: $%.2f, Total: $%.2f]",
                roomType, numberOfNights, weekend, getPrice(), getReservationTotal());
    }
}
