package lk.dinuka.springthreeemp.service;

import lk.dinuka.springthreeemp.model.Employee;
import lk.dinuka.springthreeemp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent())
            return byId.get();
        return null;
    }

    @Override
    public List<Employee> findAll(){
       return  employeeRepository.findAll();
    }
}
