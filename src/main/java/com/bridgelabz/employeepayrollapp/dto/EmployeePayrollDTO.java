package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;

public class EmployeePayrollDTO {
    public String name;
    public String profilePic;
    public char gender;
    public String[] department;
    public long salary;
    public String note;
    public LocalDate startDate;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
    }

    public EmployeePayrollDTO() {
    }

    public EmployeePayrollDTO(String name, String profilePic, char gender, String[] department, long salary,
            String note, LocalDate startDate) {
        this.name = name;
        this.profilePic = profilePic;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.note = note;
        this.startDate = startDate;
    }

}
