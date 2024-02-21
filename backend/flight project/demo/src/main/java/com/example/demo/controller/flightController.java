package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.flightModel;
import com.example.demo.service.flightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class flightController {
    private flightService flightService;
    public flightController(flightService flightService)
    {
        this.flightService=flightService;
    }
    @PostMapping("/flight")
    public ResponseEntity<flightModel> postflight(@RequestBody flightModel flightModel) 
    {
       if(flightService.saveFlight(flightModel)==true)
       {
        return new ResponseEntity<>(flightModel,HttpStatus.CREATED);
       }
       return new ResponseEntity<>(flightModel,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/flight")
    public ResponseEntity<List<flightModel>> getflights()
    {
       List<flightModel> f =flightService.getflights();
       if(f.size()==0)
       {
        return new ResponseEntity<>(f,HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(f,HttpStatus.OK);
    }
    
    @DeleteMapping("/flight/{id}")
    public void delete(@PathVariable int id)
    {
        flightService.delete(id);
    }

    @PutMapping("/flight/{id}")
    public flightModel putMethodName(@PathVariable int id, @RequestBody flightModel entity) {
        flightService.update(id, entity);
        return entity;
    }

    
}