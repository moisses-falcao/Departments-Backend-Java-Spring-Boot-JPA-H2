package com.departs.departments.controllers;

import com.departs.departments.models.EmployeeModel;
import com.departs.departments.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeModel> getAll() {
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public EmployeeModel create(@RequestBody EmployeeModel employee) {
        return employeeRepository.save(employee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
