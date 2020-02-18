package lk.dinuka.springfour.employeeservice.service;

import lk.dinuka.springfour.employeeservice.hystrix.AllocationCommand;
import lk.dinuka.springfour.employeeservice.model.Employee;
import lk.dinuka.springfour.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate template;

    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent()) {
            Employee employee = byId.get();

            HttpHeaders httpHeaders = new HttpHeaders();

            AllocationCommand allocationCommand = new AllocationCommand(employee.getId(), httpHeaders, template);
            employee.setAllocations(allocationCommand.execute());
            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> findAll(){
        return  employeeRepository.findAll();
    }
}
