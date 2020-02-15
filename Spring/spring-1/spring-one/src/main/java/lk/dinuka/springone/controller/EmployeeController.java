package lk.dinuka.springone.controller;

import lk.dinuka.springone.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/welcome")
    public String welcome(){
        return "<h1>Hello Spring</h1>";
    }

    @RequestMapping(value = "/employeesJSON",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> employeesJSON(){
        return Employee.getAllEmployees();
    }

    @RequestMapping(value = "/employeesXML",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> employeesXML(){
        return Employee.getAllEmployees();
    }

}
