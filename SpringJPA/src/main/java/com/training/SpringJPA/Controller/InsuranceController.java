package com.training.SpringJPA.Controller;

import com.training.SpringJPA.Entity.Insurance;
import com.training.SpringJPA.Repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class InsuranceController {

    @Autowired
    InsuranceRepository insuranceRepository;

    @PostMapping("/DBInsertion")
    public String insertingValuesintoDB(){
        System.out.println("First Time Insertion of Random Values");
        for(int i=0;i<10;i++) {
            Insurance insurance = new Insurance(i, "Name" + i, 100000 + i,
                    (new Random().nextInt(10)%2==0?"Montly":"Yearly"));
            insuranceRepository.save(insurance);
        }
        return "Random DB Values Inserted Successfully";
    }

    @GetMapping("/getAllPolicies")
    public List<Insurance> getAllPolicies(){
        List<Insurance> insuranceList = insuranceRepository.findAll();
        return insuranceList;
    }

    @GetMapping("/getPolicy/{policyNumber}")
    public List<Insurance> getAllPoliciesGreaterThan(@PathVariable int policyNumber){
        System.out.println("The total policies are"+ insuranceRepository.count());
        List<Insurance> insuranceListGreaterThan =
                insuranceRepository.findByPolicyNumberGreaterThanAndPayMethod(policyNumber,"Montly");
        return insuranceListGreaterThan;
    }

    @PutMapping("/updatePolicy")
    public String updatePloicy(@RequestBody Insurance insurance){
        Optional<Insurance> insuranceOptional = insuranceRepository.findById(insurance.getPolicyNumber());
        if(insuranceOptional.isPresent()){
            Insurance insuranceToUpdate = insuranceOptional.get();
            insuranceToUpdate.setPolicyNumber(insurance.getPolicyNumber());
            insuranceToUpdate.setPolicyHolderName(insurance.getPolicyHolderName());
            insuranceToUpdate.setTotalSumAssured(insurance.getTotalSumAssured());
            insuranceToUpdate.setPayMethod(insurance.getPayMethod());
            insuranceRepository.save(insuranceToUpdate);
            return "Policies updated Successfully";
        }
        return "Policies not found";
    }

    @DeleteMapping("/deletePolicy/{policyNumber}")
    public String deletePolicy(@PathVariable int policyNumber){
        Optional<Insurance> insuranceDeleteOptional = insuranceRepository.findById(policyNumber);
        if(insuranceDeleteOptional.isPresent()){
            insuranceRepository.deleteById(policyNumber);
            return "Policy Deleted Successfully";
        }
        return "Policy not found to be deleted";
    }

}
