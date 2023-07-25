package com.dc.latam.domain.service;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.domain.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    public List<DomainEmployee> getAll() {
        return this.iEmployeeRepository.getAll();
    }
    public Optional<DomainEmployee> getById(Long employeeId) {
        return this.iEmployeeRepository.getById(employeeId);
    }
}
