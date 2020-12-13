package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    public String profilePic;
    public char gender;
    public String[] department;
    @Min(value = 300000, message = "Salary less than minimum wage")
    public long salary;
    public String note;
    public LocalDate startDate;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

}
