package com.pluarlsight;

public class Employee {

    // --- Settings for Pay Calculation ---
    private static final double REGULAR_HOURS_LIMIT = 40.0; // Max regular hours before overtime
    private static final double OVERTIME_PAY_FACTOR = 1.5;  // How much more overtime hours pay (e.g., 1.5 = time and a half)

    // --- Basic Employee Information (stored for each employee object) ---
    private int employeeId;
    private String name;
    private String department;
    private double payRate;      // How much the employee earns per hour
    private double hoursWorked;  // Total hours the employee worked


    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;

        // Make sure pay rate and hours are not negative
        this.payRate = (payRate < 0) ? 0 : payRate;
        this.hoursWorked = (hoursWorked < 0) ? 0 : hoursWorked;
    }

    // --- Methods to Get Employee Information ---
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getPayRate() { return payRate; }
    public double getHoursWorked() { return hoursWorked; }

    // --- Methods to Update Employee Information (Optional) ---
    public void setPayRate(double payRate) {
        if (payRate >= 0) this.payRate = payRate; // Only update if valid
    }
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0) this.hoursWorked = hoursWorked; // Only update if valid
    }

    // --- Calculated Information (Derived Getters - these figure things out) ---


    public double getRegularHours() {
        if (this.hoursWorked <= REGULAR_HOURS_LIMIT) {
            return this.hoursWorked; // All hours are regular
        } else {
            return REGULAR_HOURS_LIMIT; // Worked more than regular limit, so cap at limit
        }
    }


    public double getOvertimeHours() {
        if (this.hoursWorked > REGULAR_HOURS_LIMIT) {
            return this.hoursWorked - REGULAR_HOURS_LIMIT; // Hours beyond the regular limit
        } else {
            return 0; // No hours were over the limit
        }
    }


    public double getTotalPay() {
        // Get the calculated regular and overtime hours
        double regularHours = getRegularHours();
        double overtimeHours = getOvertimeHours();

        // Calculate pay for regular hours
        double regularPay = regularHours * this.payRate;

        // Calculate pay for overtime hours (if any)
        double overtimePay = overtimeHours * this.payRate * OVERTIME_PAY_FACTOR;

        // Add them up for the total
        return regularPay + overtimePay;
    }

    // --- Method to Print Employee Info Nicely ---
    @Override
    public String toString() {
        return String.format(
                "Employee ID: %d, Name: %s, Dept: %s\n" +
                        "  Pay Rate: $%.2f/hr, Hours Worked: %.1f\n" +
                        "  Regular Hours: %.1f, Overtime Hours: %.1f\n" +
                        "  Total Pay: $%.2f",
                employeeId, name, department,
                payRate, hoursWorked,
                getRegularHours(), getOvertimeHours(), getTotalPay()
        );
    }
}
