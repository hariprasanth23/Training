package com.training.crudRepositoryExample.repsository;

import com.training.crudRepositoryExample.Entity.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InsurancePagingRepository extends PagingAndSortingRepository<Insurance, Integer> {
    Page<Insurance> findAll(Pageable pageable);
    Page<Insurance> findByPolicyHolderName(String policyHolderName , Pageable pageable);
}
