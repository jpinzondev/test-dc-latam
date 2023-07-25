package com.dc.latam.persistence;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.domain.repository.IEmployeeRepository;
import com.dc.latam.persistence.crud.IEmployeeCrudRepository;
import com.dc.latam.persistence.entity.Employee;
import com.dc.latam.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository implements IEmployeeRepository {
    @Autowired
    private IEmployeeCrudRepository iEmployeeCrudRepository;
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public List<DomainEmployee> getAll() {
        List<Employee> employees = (List<Employee>) this.iEmployeeCrudRepository.findAll();
        return mapper.toEmployees(employees);
    }
    @Override
    public Optional<DomainEmployee> getById(Long employeeId) {
        Optional<Employee> employee = this.iEmployeeCrudRepository.findById(employeeId);
        return employee.map(currentEmployee -> mapper.toEmployee(currentEmployee));
    }
}
