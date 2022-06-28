package com.Knoldus.CRUDMockito.service;

import com.Knoldus.CRUDMockito.entity.Employee;
import com.Knoldus.CRUDMockito.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The type Employee service.
 */
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    /**
     * Save employee.
     *
     * @param employee the employee
     * @return the employee
     */
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    /**
     * Save employee list.
     *
     * @param employee the employee
     * @return the list
     */
    public List<Employee> saveEmployee(List<Employee> employee) {
        return repository.saveAll(employee);
    }

    /**
     * Get all employee .
     *
     * @return the employee
     */
    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    /**
     * Get employee by name
     *
     * @param name the name
     * @return the employee by name
     */
    public Employee getEmployeeByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Get employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Delete employee by id .
     *
     * @param id the id
     * @return the string
     */
    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    /**
     * Update employee.
     *
     * @param employee the employee
     * @return the employee
     */
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        assert existingEmployee != null;
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.getEmail();
        return repository.save(existingEmployee);
    }


}
