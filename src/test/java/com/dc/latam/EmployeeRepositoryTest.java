package com.dc.latam;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.persistence.EmployeeRepository;
import com.dc.latam.persistence.crud.IEmployeeCrudRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getListOfEmployeesTest() {
        List<DomainEmployee> employees = employeeRepository.getAll();
        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }
    @Test
    @DisplayName("DATA JPA JUnit test for getAllEmployees method")
    public void getEmployeeByTest() {
        Optional<DomainEmployee> employee = employeeRepository.getById(1L);
        if (employee.isPresent()) {
            DomainEmployee e = employee.get();
            Assertions.assertThat(e.getId()).isEqualTo(1L);
        }
    }
}
