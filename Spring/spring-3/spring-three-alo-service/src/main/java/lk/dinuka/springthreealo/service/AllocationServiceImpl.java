package lk.dinuka.springthreealo.service;

import lk.dinuka.springthreealo.model.Allocation;
import lk.dinuka.springthreealo.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation save(Allocation e) {
        return allocationRepository.save(e);
    }

    @Override
    public Allocation findById(Integer id) {
        Optional<Allocation> byId = allocationRepository.findById(id);
        if (byId.isPresent())
            return byId.get();
        return null;
    }

    @Override
    public List<Allocation> findAll() {
        return allocationRepository.findAll();
    }

    @Override
    public Allocation[] findByEmp(Integer id) {
        Allocation allocation = new Allocation();
        allocation.setEmployee(id);
        List<Allocation> all = allocationRepository.findAll(Example.of(allocation));
        return all.toArray(new Allocation[all.size()]);
    }


}
