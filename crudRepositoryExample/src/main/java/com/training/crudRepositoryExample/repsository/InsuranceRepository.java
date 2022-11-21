package com.training.crudRepositoryExample.repsository;

import com.training.crudRepositoryExample.Entity.Insurance;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<Insurance,Integer> {
}
