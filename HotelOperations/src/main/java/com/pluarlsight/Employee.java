package com.pluarlsight;


import java.time.LocalDateTime;

public class Employee {

    private static final double REGULAR_HOURS_LIMIT = 40.0;
    private static final double OVERTIME_PAY_FACTOR = 1.5;

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private double currentPunchInTime;
    private boolean currentlyPunchedIn;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = Math.max(0, payRate);
        this.hoursWorked = Math.max(0, hoursWorked);
        this.currentlyPunchedIn = false;
    }

    // Getters
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getHoursWorked() { return hoursWorked; }
    public boolean isCurrentlyPunchedIn() { return currentlyPunchedIn; }
    public double getCurrentPunchInTimeValue() { return currentlyPunchedIn ? currentPunchInTime : -1.0; }


    // Punch methods with manual time
    public void punchIn(double time) {
        if (time < 0 || time >= 24) return;
        this.currentPunchInTime = time;
        this.currentlyPunchedIn = true;
        System.out.println(name + " punched in (manual) at " + String.format("%.2f", time));
    }

    public void punchOut(double time) {
        if (time < 0 || time >= 24 || !this.currentlyPunchedIn || time < this.currentPunchInTime) return;
        double shiftDuration = time - this.currentPunchInTime;
        this.hoursWorked += shiftDuration;
        this.currentlyPunchedIn = false;
        System.out.println(name + " punched out (manual) at " + String.format("%.2f", time) + ". Shift: " + String.format("%.2f", shiftDuration) + " hrs.");
    }

    // Overloaded punch methods using current time
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + (now.getMinute() / 60.0);
        this.currentPunchInTime = currentTime;
        this.currentlyPunchedIn = true;
        System.out.println(name + " punched in (current) at " + String.format("%.2f (%02d:%02d)", currentTime, now.getHour(), now.getMinute()));
    }

    public void punchOut() {
        if (!this.currentlyPunchedIn) return;
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + (now.getMinute() / 60.0);
        if (currentTime < this.currentPunchInTime) return; // Simple same-day check

        double shiftDuration = currentTime - this.currentPunchInTime;
        this.hoursWorked += shiftDuration;
        this.currentlyPunchedIn = false;
        System.out.println(name + " punched out (current) at " + String.format("%.2f (%02d:%02d)", currentTime, now.getHour(), now.getMinute()) + ". Shift: " + String.format("%.2f", shiftDuration) + " hrs.");
    }

    // Derived Pay Getters
    public double getRegularHours() { return Math.min(this.hoursWorked, REGULAR_HOURS_LIMIT); }
    public double getOvertimeHours() { return Math.max(0, this.hoursWorked - REGULAR_HOURS_LIMIT); }
    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * OVERTIME_PAY_FACTOR);
    }

    @Override
    public String toString() {
        String punchStatus = currentlyPunchedIn ? "Punched In at " + String.format("%.2f", currentPunchInTime) : "Not Punched In";
        return String.format("Emp ID: %d, %s (%s) - Rate: $%.2f, Hrs: %.2f, Pay: $%.2f",
                employeeId, name, punchStatus, payRate, hoursWorked, getTotalPay());
    }
}

