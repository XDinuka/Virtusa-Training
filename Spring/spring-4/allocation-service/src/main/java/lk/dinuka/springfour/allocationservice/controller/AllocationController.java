package lk.dinuka.springfour.allocationservice.controller;

import lk.dinuka.springfour.allocationservice.model.Allocation;
import lk.dinuka.springfour.allocationservice.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocations")
public class AllocationController {


    @Autowired
    AllocationService allocationService;

    @PostMapping(value = "/save")
    public Allocation save(@RequestBody Allocation employee) {
        return allocationService.save(employee);
    }

    @GetMapping(value = "/findAll")
    public List<Allocation> findAll() {
        return allocationService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Allocation findById(@PathVariable("id") Integer id) {
        return allocationService.findById(id);
    }

    @GetMapping(value = "/findByEmployee/{id}")
    public Allocation[] findByEmp(@PathVariable("id") Integer id){
        return allocationService.findByEmp(id);
    }

}
