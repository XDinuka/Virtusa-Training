package lk.dinuka.springthreeemp.controller;

import lk.dinuka.springthreeemp.model.Allocation;
import lk.dinuka.springthreeemp.model.Employee;
import lk.dinuka.springthreeemp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class Employees {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestTemplate template;

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
        if(byId!=null){

            HttpHeaders httpHeaders =  new HttpHeaders();
            HttpEntity<String> httpEntity =  new HttpEntity<>("",httpHeaders);


            ResponseEntity<Allocation[]> forEntity = template.exchange(
                    "http://localhost:5001/allocations/findByEmployee/" + byId.getId(),
                    HttpMethod.GET,
                    httpEntity,
                    Allocation[].class
            );
            if(forEntity.getStatusCode().value()==200){
                byId.setAllocations(forEntity.getBody());
            }


        }
        return byId;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }
}
