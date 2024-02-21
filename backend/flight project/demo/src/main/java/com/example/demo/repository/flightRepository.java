
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.flightModel;

@Repository
public interface flightRepository extends JpaRepository<flightModel,Integer>{

    
}