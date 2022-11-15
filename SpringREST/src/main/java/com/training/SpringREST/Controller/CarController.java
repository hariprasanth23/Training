package com.training.SpringREST.Controller;

import com.training.SpringREST.Entity.Car;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring REST";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String Username, @RequestParam String Password){
        return (Username.equals("Hari")&&(Password.equals("")))?"Logging in":"Invalid Login";
    }

    @GetMapping("/getcars")
    public Car getcar(){
        Car car = new Car("101","Rolls-Royce",1997,"whilte","Petrol");
        return car;
    }

    @PostMapping("/insertCar")
    public String insertCar(@RequestBody Car car){
        System.out.println("Inserting car records"+car);
        return "Inserted Car Successfully";
    }

    @PutMapping("/updateCar")
    public String updateCar(@RequestBody Car car){
        System.out.println("updating car records"+car);
        return "Updated Car Successfully";
    }

    @DeleteMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable int id){
        System.out.println("Deleting Car Records"+id);
        return "Deleted Car Successfully";
    }


}
