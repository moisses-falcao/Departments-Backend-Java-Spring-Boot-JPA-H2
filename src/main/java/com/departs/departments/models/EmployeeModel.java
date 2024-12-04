package com.departs.departments.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public DepartmentModel getDepartment() {
        return department;
    }
    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }
}