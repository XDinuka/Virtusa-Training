package lk.dinuka.springfour.employeeservice.service;

import lk.dinuka.springfour.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee e);

    Employee findById(Integer id);

    List<Employee> findAll();
}
