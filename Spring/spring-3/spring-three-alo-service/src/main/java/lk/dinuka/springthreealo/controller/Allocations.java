package lk.dinuka.springthreealo.controller;

import lk.dinuka.springthreealo.model.Allocation;
import lk.dinuka.springthreealo.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/allocations")
public class Allocations {

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
