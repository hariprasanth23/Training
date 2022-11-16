package com.training.SpringJPA.Repository;

import com.training.SpringJPA.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
    List<Insurance> findByPolicyNumberGreaterThanAndPayMethod(int policyNumber,String payMethod);
}
