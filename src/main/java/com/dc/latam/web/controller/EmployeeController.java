package com.dc.latam.web.controller;

import com.dc.latam.domain.dto.DomainEmployee;
import com.dc.latam.domain.service.EmployeeService;
import com.dc.latam.web.exceptions.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<DomainEmployee>> getAll() {
        try {
            return new ResponseEntity<>(this.employeeService.getAll(), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainEmployee> getEmployee(@PathVariable("id") long employeeId) {
        try {
            return this.employeeService.getById(employeeId).
                    map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (RequestException ex) {
            throw new RequestException(ex.getCode(), ex.getStatus(), ex.getMessage());
        }

    }
}
