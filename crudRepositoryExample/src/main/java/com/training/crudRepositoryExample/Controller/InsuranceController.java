package com.training.crudRepositoryExample.Controller;

import com.training.crudRepositoryExample.Entity.Insurance;
import com.training.crudRepositoryExample.repsository.InsuranceJPARepository;
import com.training.crudRepositoryExample.repsository.InsurancePagingRepository;
import com.training.crudRepositoryExample.repsository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class InsuranceController {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Autowired
    InsurancePagingRepository insurancePagingRepository;

    @Autowired
    InsuranceJPARepository insuranceJPARepository;

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

    @GetMapping("/getAllInsuranceList")
    public List<Insurance> getInsuranceList(){
        List<Insurance> insuranceList = new ArrayList<>();
        System.out.println(" Total insurance policies "+ insuranceRepository.count() );
        insuranceRepository.findAll().forEach(insurance -> insuranceList.add(insurance));
        return insuranceList;
    }

    @GetMapping("/getInsurance/{id}")
    public Insurance getInsurance(@PathVariable int id){
        return insuranceRepository.findById(id).get();
    }

    @GetMapping("/getTwoId")
    public List<Insurance> getAllId(){
        List<Insurance> insuranceList = new ArrayList<>();
        insuranceRepository.findAllById(Arrays.asList(4,5)).forEach(insurance -> insuranceList.add(insurance));
        return insuranceList;
    }

    @GetMapping("/exists/{id}")
    public Boolean exists(@PathVariable int id){
        return insuranceRepository.existsById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteById(@PathVariable int id){
        System.out.println("Deleting the id");
        insuranceRepository.deleteById(id);
    }

    @DeleteMapping("/deleteTwoId")
    public void getDeleteId(){
        List<Insurance> insuranceList = new ArrayList<>();
        insuranceRepository.deleteAllById(Arrays.asList(4,5));
    }

    @GetMapping("/getPaging")
    public Page<Insurance> pagingMethod(){
        Pageable firstPageWithTwoElements = PageRequest.of(0,2);
        Page<Insurance> allInsurance = insurancePagingRepository.findAll(firstPageWithTwoElements);
        return allInsurance;
    }

    @GetMapping("/getJPA")
    public void nativeQueryExecution(){
        System.out.println("\n Usage of JPA repository Started");
        insuranceJPARepository.getAllInsuranceById(4).forEach(System.out::println);

        System.out.println("\n findByTotalSumAssuredGreaterThanEqual ");
        insuranceJPARepository.findByTotalSumAssuredGreaterThanEqual(100003).forEach(System.out::println);

        System.out.println("\n findByPolicyHolderNameContaining ");
        insuranceJPARepository.findByPolicyHolderNameContaining("Name3").forEach(System.out::println);

        System.out.println("\n findByPayMethodStartingWith ");
        insuranceJPARepository.findByPayMethodStartingWith("Mon").forEach(System.out::println);

        System.out.println("\n findFirstByPolicyHolderName ");
        insuranceJPARepository.findFirstByPolicyHolderName("Name0").toString();

        System.out.println("\n findTopByPolicyHolderName ");
        insuranceJPARepository.findTopByPolicyHolderName("Name0").toString();

        System.out.println("\n findByPayMethodOrPolicyNumberGreaterThan ");
        insuranceJPARepository.findByPayMethodOrPolicyNumberGreaterThan("Montly",1).
                forEach(System.out::println);
    }
}
