package org.example.employee_api.Controller;


import org.example.employee_api.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.employee_api.service.EmployeeService;
import org.example.employee_api.model.employee1;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //creating
    @PostMapping
    public ResponseEntity<employee1> create(@RequestBody employee1 emp) {
        employee1 saved = employeeService.save(emp);

        return ResponseEntity
                .created(URI.create("/api/employees/" + saved.getId()))
                .body(saved);
    }

    //Reading the employee
    @GetMapping
    public List<employee1> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<employee1> getEmployeeById(@PathVariable Long id) {
        try {
            employee1 emp = employeeService.findById(id);
            return ResponseEntity.ok().body(emp);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<employee1> update(@PathVariable Long id, @RequestBody employee1 emp) {
        try {
            employee1 existing = employeeService.findById(id);
            existing.setFirst_name(emp.getFirst_name());
            existing.setLast_name(emp.getLast_name());
            existing.setEmail(emp.getEmail());
            existing.setDepartment(emp.getDepartment());
            existing.setSalary(emp.getSalary());
            employee1 updated = employeeService.save(existing);
            return ResponseEntity.ok().body(updated);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try{
            employeeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch(NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }

}
