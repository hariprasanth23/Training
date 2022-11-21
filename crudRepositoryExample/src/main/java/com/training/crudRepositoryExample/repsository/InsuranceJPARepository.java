package com.training.crudRepositoryExample.repsository;

import com.training.crudRepositoryExample.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InsuranceJPARepository extends JpaRepository<Insurance,Integer> {

    @Query(value= "select * from Insurance where policy_number=?1",nativeQuery = true)
    List<Insurance> getAllInsuranceById(int policyNumber);

    List<Insurance> findByTotalSumAssuredGreaterThanEqual(int totalSumAssured);
    List<Insurance> findByPolicyHolderNameContaining(String policyHolderName);
    List<Insurance> findByPayMethodStartingWith(String payMethod);
    Insurance findFirstByPolicyHolderName(String policyHolderName);
    Insurance findTopByPolicyHolderName(String policyHolderName);
    List<Insurance> findByPayMethodOrPolicyNumberGreaterThan(String payMethod, int policyNumber);
}
