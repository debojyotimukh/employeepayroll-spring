package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private String profilePic;
    private char gender;
    private String[] department;
    private long salary;
    private String note;
    private LocalDate startDate;

    public EmployeePayrollData() {

    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.profilePic = employeePayrollDTO.profilePic;
        this.gender = employeePayrollDTO.gender;
        this.department = employeePayrollDTO.department;
        this.salary = employeePayrollDTO.salary;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.profilePic = employeePayrollDTO.profilePic;
        this.gender = employeePayrollDTO.gender;
        this.department = employeePayrollDTO.department;
        this.salary = employeePayrollDTO.salary;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String[] getDepartment() {
        return department;
    }

    public void setDepartment(String[] department) {
        this.department = department;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
