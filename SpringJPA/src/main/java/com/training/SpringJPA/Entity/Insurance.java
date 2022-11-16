package com.training.SpringJPA.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {

    @Id
    int policyNumber;
    String policyHolderName;
    int totalSumAssured;
    String payMethod;

}
