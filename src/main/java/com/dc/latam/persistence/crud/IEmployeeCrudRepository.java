package com.dc.latam.persistence.crud;

import com.dc.latam.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeCrudRepository extends CrudRepository<Employee, Long> {
}
