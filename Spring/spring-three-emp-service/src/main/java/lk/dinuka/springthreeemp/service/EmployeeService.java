package lk.dinuka.springthreeemp.service;

import lk.dinuka.springthreeemp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee e);

    Employee findById(Integer id);

    List<Employee> findAll();
}
