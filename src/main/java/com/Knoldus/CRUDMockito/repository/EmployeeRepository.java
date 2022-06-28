package com.Knoldus.CRUDMockito.repository;

import com.Knoldus.CRUDMockito.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    /**
     * Find by name product.
     *
     * @param name the name
     * @return the product
     */
    Employee findByName(String name);
}

