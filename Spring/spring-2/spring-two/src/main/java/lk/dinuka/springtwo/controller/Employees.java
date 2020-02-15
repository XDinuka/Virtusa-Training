package lk.dinuka.springtwo.controller;

import lk.dinuka.springtwo.model.Employee;
import lk.dinuka.springtwo.model.Telephone;
import lk.dinuka.springtwo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class Employees {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        if(employee.getTelephones()!=null)
        employee.getTelephones().stream().forEach(tp->tp.setEmployee(employee));
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        return employeeService.findById(id).get();
    }

}
