package lk.dinuka.springfour.allocationservice.service;

import lk.dinuka.springfour.allocationservice.model.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation save(Allocation e);

    Allocation findById(Integer id);

    List<Allocation> findAll();

    Allocation[] findByEmp(Integer id);
}
