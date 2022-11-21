package com.training.crudRepositoryExample.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    private int policyNumber;
    private String policyHolderName;
    private int totalSumAssured;
    private String payMethod;
}
