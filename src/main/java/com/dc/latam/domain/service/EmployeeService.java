package com.dc.latam.domain.service;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.domain.repository.IEmployeeRepository;
import com.dc.latam.web.exceptions.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    private static final int NUM_MONTHS = 12;

    public List<DomainEmployee> getAll() {
        List<DomainEmployee> employees = this.iEmployeeRepository.getAll();
        for (DomainEmployee employee: employees) {
            employee.setEmployeeAnualSalary(employee.getEmployeeSalary() * NUM_MONTHS);
        }
        return employees;
    }
    public Optional<DomainEmployee> getById(Long employeeId) {
         Optional<DomainEmployee> employee = this.iEmployeeRepository.getById(employeeId);
         if(employee.isPresent()) {
             DomainEmployee currentEmployee = employee.get();
             currentEmployee.setEmployeeAnualSalary(currentEmployee.getEmployeeSalary() * NUM_MONTHS);
             return Optional.of(currentEmployee);
         } else {
            throw new RequestException(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND, "Employee does not exist");
         }
    }
}
