package lk.dinuka.springthreealo.service;


import lk.dinuka.springthreealo.model.Allocation;

import java.util.List;

public interface AllocationService {

    Allocation save(Allocation e);

    Allocation findById(Integer id);

    List<Allocation> findAll();

    Allocation[] findByEmp(Integer id);
}
