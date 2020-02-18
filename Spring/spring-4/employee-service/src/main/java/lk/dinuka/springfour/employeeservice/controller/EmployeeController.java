package lk.dinuka.springfour.employeeservice.controller;

import lk.dinuka.springfour.employeeservice.hystrix.AllocationCommand;
import lk.dinuka.springfour.employeeservice.model.Allocation;
import lk.dinuka.springfour.employeeservice.model.Employee;
import lk.dinuka.springfour.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;



    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        if (employee.getTelephones() != null)
            employee.getTelephones().stream().forEach(tp -> tp.setEmployee(employee));
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @RequestMapping("/find/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        Employee byId = employeeService.findById(id);

        return byId;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }
}
