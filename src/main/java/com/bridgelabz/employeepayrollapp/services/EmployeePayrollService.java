package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository payrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return payrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        if(payrollRepository.findById(empId).isEmpty())
            throw new EmployeePayrollException("Required employee data not found!");
        return payrollRepository.findById(empId).get();
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {

        return payrollRepository.save(new EmployeePayrollData(employeePayrollDTO));
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        // TODO exception in case not exists

        EmployeePayrollData payrollData = payrollRepository.getOne(empId);
        
        payrollData.setName(employeePayrollDTO.name);
        payrollData.setSalary(employeePayrollDTO.salary);
        payrollData.setDepartment(employeePayrollDTO.department);
        payrollData.setGender(employeePayrollDTO.gender);
        payrollData.setNote(employeePayrollDTO.note);
        payrollData.setProfilePic(employeePayrollDTO.profilePic);
        payrollData.setStartDate(employeePayrollDTO.startDate);

        payrollRepository.save(payrollData);

        return getEmployeePayrollDataById(empId);
    }

    @Override
    public void deleteEmployeePayrollData(int empID) {
        // TODO exception in case not exists
        payrollRepository.deleteById(empID);
    }

}
