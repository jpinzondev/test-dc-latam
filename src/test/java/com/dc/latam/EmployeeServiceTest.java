package com.dc.latam;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.domain.service.EmployeeService;
import com.dc.latam.persistence.EmployeeRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    @Autowired
    EmployeeService employeeService;
    private DomainEmployee employeeDTO;
    @BeforeEach
    public void setup() {

        employeeDTO = new DomainEmployee(
                1L,
                "Jorge",
                4500000,
                28,
                ""
        );
    }

    @DisplayName("JUnit test for getAllEmployees method")
    @Test
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList(){
        DomainEmployee employee1 = new DomainEmployee(
                1L,
                "Jorge",
                4500000,
                28,
                ""
        );

        given(employeeRepository.getAll()).willReturn(List.of(employeeDTO, employee1));
        // when -  action or the behaviour that we are going test

        List<DomainEmployee> employeeList = employeeService.getAll();
        // then - verify the output
        Assertions.assertThat(employeeList).isNotNull();
        Assertions.assertThat(employeeList.size()).isEqualTo(2);
    }
}
