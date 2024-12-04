package com.departs.departments.controllers;

import com.departs.departments.models.DepartmentModel;
import com.departs.departments.repositories.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @GetMapping
    public List<DepartmentModel> getAll() {
        return departmentRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentModel> getById(@PathVariable Long id) {
        return departmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public DepartmentModel create(@RequestBody DepartmentModel department) {
        return departmentRepository.save(department);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
