package com.Knoldus.CRUDMockito.controller;

import com.Knoldus.CRUDMockito.entity.Employee;
import com.Knoldus.CRUDMockito.repository.EmployeeRepository;
import com.Knoldus.CRUDMockito.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * The type Employee controller test.
 */
@AutoConfigureMockMvc
@SpringBootTest()
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @MockBean
    private EmployeeController employeeController;
    private EmployeeRepository employeeRepository;

    /**
     * The Object mapper.
     */
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * The Employee.
     */
    Employee employee = new Employee(1,"Shivam","Roy","shivam.roy@knoldus.com");

    /**
     * Should add the new product.
     *
     * @throws Exception the exception
     */
    @Test
    public void addProduct() throws Exception {
        BDDMockito.given(employeeService.saveEmployee(employee))
                .willReturn(employee);
        mockMvc.perform(post("/employee/addEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    /**
     * Should delete the employee with their id .
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteEmployee() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                delete("/employee/deleteEmployee/1")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Should get employee by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void should_get_person_by_id() throws Exception {
        BDDMockito.given(employeeService.getEmployeeById(1))
                .willReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.
                        get("/getEmployee/1")).
                andExpect(status().isOk());
    }

}
