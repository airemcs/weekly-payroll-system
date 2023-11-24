package com.model;

public class Employee {
    
    private double dailyRate;
    private int inTime;
    private int outTime;
    private String dayType;
    private double daySalary;

    private int nightHours;
    private int overtimeHours;

    public Employee() {
        this.dailyRate = 500;
        this.inTime = 900;
        this.outTime = 900;
        this.dayType = "Normal Day";
        this.nightHours = 0;
        this.overtimeHours = 0;
        calculateHours();
    }

    // Generates and Assigns Values for Hours
    private void calculateHours() {

        if (outTime < 600) this.nightHours += (outTime + 2400 - 2200) / 100;
        if (outTime == 0) this.nightHours = 2;
        if (outTime >= 2200) this.nightHours += (outTime - 2200) / 100;

        this.overtimeHours = (outTime < inTime) ? (outTime - inTime + 2400 - 900) / 100 : (outTime - inTime - 900) / 100;
        if (overtimeHours > nightHours) this.overtimeHours -= nightHours;
        
        if (inTime == outTime) {
            this.nightHours = 0;
            this.overtimeHours = 0;
        }

        // TODO: Debug Night Shift
        calculateSalary();

    }

    private void calculateSalary() {

        double rate = 0;
        double overtimeRate = 0;
        double nightRate = 0;
        this.daySalary = 0;

        switch (this.dayType) {
            case "Normal Day": rate = 1.0; break;
            case "Rest Day": rate = 1.3; break;
            case "Special Non-Working": rate = 1.3; break;
            case "Special Non-Working and Rest Day": rate = 1.5; break;
            case "Regular Holiday": rate = 2.0; break;
            case "Regular Holiday and Rest Day": rate = 2.6;
        }

        switch (this.dayType) {
            case "Normal Day": overtimeRate = 1.25; break;
            case "Rest Day": overtimeRate = 1.69; break;
            case "Special Non-Working": overtimeRate = 1.69; break;
            case "Special Non-Working and Rest Day": overtimeRate = 1.95; break;
            case "Regular Holiday": overtimeRate = 2.6; break;
            case "Regular Holiday and Rest Day": overtimeRate = 3.38; 
        }

        switch (this.dayType) {
            case "Normal Day": nightRate = 1.375; break;
            case "Rest Day": nightRate = 1.859; break;
            case "Special Non-Working": nightRate = 1.859; break;
            case "Special Non-Working and Rest Day": nightRate = 2.145; break;
            case "Regular Holiday": nightRate = 2.86; break;
            case "Regular Holiday and Rest Day": nightRate = 3.718; 
        }

        this.daySalary += this.dailyRate * rate;
        this.daySalary += this.overtimeHours * this.dailyRate / 8 * overtimeRate;
        this.daySalary += this.nightHours * this.dailyRate / 8 * nightRate;

    }

    public double getRate() {
        return this.dailyRate;
    }

    public int getInTime() {
        return this.inTime;
    }

    public int getOutTime() {
        return this.outTime;
    }

    public String getDayType() {
        return this.dayType;
    }

    public int getNightHours() {
        return this.nightHours;
    }

    public int getOvertimeHours() {
        return this.overtimeHours;
    }

    public double getSalary() {
        return this.daySalary;
    }

    public void setRate(double dailyRate) {
        this.dailyRate = dailyRate;
        calculateHours();
    }

    public void setInTime(int inTime) {
        this.inTime = inTime;
        calculateHours();
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
        calculateHours();
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
        calculateHours();
    }

}
