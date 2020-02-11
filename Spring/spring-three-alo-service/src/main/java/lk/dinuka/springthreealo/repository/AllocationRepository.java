package lk.dinuka.springthreealo.repository;

import lk.dinuka.springthreealo.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
