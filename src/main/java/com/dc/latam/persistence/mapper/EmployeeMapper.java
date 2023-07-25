package com.dc.latam.persistence.mapper;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.persistence.entity.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
        @Mapping(source = "employeeId", target = "id"),
        @Mapping(source = "name", target = "employeeName"),
        @Mapping(source = "salary", target = "employeeSalary"),
        @Mapping(source = "age", target = "employeeAge"),
        @Mapping(source = "profileImage", target = "profileImage")
    })
    DomainEmployee toEmployee(Employee employee);
    List<DomainEmployee> toEmployees(List<Employee> employees);
    @InheritInverseConfiguration()
    Employee toEntityEmployee(DomainEmployee employee);
}
