package com.dc.latam.persistence;

import com.dc.latam.persistence.crud.IEmployeeCrudRepository;
import com.dc.latam.persistence.entity.Employee;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private IEmployeeCrudRepository iEmployeeCrudRepository;

    public List<Employee> getAll() {
        return (List<Employee>) this.iEmployeeCrudRepository.findAll();
    }

    public Optional<Employee> getById(Long employeeId) {
       return this.iEmployeeCrudRepository.findById(employeeId);
    }
}
