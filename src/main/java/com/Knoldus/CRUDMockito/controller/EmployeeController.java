package com.Knoldus.CRUDMockito.controller;

import com.Knoldus.CRUDMockito.entity.Employee;
import com.Knoldus.CRUDMockito.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /**
     * Add employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    /**
     * Add employee list.
     *
     * @param employee the employee
     * @return the list
     */
    @PostMapping("/addProducts")
    public List<Employee> addEmployee(@RequestBody List<Employee> employee) {
        return service.saveEmployee(employee);
    }

    /**
     * Find all employee list.
     *
     * @return the list
     */
    @GetMapping("/getEmployee")
    public List<Employee> findAllEmployee() {
        return service.getEmployee();
    }

    /**
     * Find employee by id .
     *
     * @param id the id
     * @return the employee
     */
    @GetMapping("/getEmployee/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    /**
     * Find employee by name.
     *
     * @param name the name
     * @return the employee
     */
    @GetMapping("/employee/{name}")
    public Employee findEmployeeByName(@PathVariable String name) {
        return service.getEmployeeByName(name);
    }

    /**
     * Update employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    /**
     * Delete employee by id.
     *
     * @param id the id
     * @return the string
     */
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
