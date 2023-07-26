package com.example.JAVASPRING1.models;

import java.util.ArrayList;
import java.util.List;

public class AttendanceDay {
    private int date;
    private double hours;
    private List<String> shifts;
    private double amount;


    public AttendanceDay(int date, double hours, List<String> shifts, double amount) {
        this.date = date;
        this.hours = hours;
        this.shifts = shifts;
        this.amount =amount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public List<String> getShifts() {
        return shifts;
    }

    public void setShifts(List<String> shifts) {
        this.shifts = shifts;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
