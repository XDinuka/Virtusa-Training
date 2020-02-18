package lk.dinuka.springfour.allocationservice.repository;

import lk.dinuka.springfour.allocationservice.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
}
