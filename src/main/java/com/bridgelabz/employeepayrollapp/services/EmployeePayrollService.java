package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private final AtomicInteger counter = new AtomicInteger();

    @Autowired
    private EmployeePayrollRepository payrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        
        return payrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {

        return payrollRepository.save(new EmployeePayrollData(counter.incrementAndGet(), employeePayrollDTO));
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteEmployeePayrollData(int empID) {
        // TODO Auto-generated method stub

    }

}
