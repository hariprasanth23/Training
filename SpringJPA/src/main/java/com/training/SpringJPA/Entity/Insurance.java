package com.training.SpringJPA.Entity;
import lombok.*;
import javax.persistence.*;

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
