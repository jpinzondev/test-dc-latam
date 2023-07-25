package com.dc.latam.domain.repository;

import com.dc.latam.domain.DomainEmployee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    List<DomainEmployee> getAll();
    Optional<DomainEmployee> getById(Long employeeId);
}
