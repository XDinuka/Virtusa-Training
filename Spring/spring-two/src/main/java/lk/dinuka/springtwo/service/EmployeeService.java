package lk.dinuka.springtwo.service;

import lk.dinuka.springtwo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee e);

    Optional<Employee> findById(Integer id);

    List<Employee> findAll();
}
