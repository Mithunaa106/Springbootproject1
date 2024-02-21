package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.flightModel;
import com.example.demo.repository.flightRepository;

@Service
public class flightService {
private flightRepository flightRepository;

public flightService(flightRepository flightRepository)
{
    this.flightRepository=flightRepository;
}

public boolean saveFlight(flightModel flightModel)
{
    try {
        flightRepository.save(flightModel);
        
    } catch (Exception e){
        return false;
    } 
    return true;
}

public List<flightModel> getflights()
{
    return flightRepository.findAll();
}

public void delete(int id)
{
    flightRepository.deleteById(id);
}
public flightModel update(int id,flightModel entity)
    {
        entity.setId(id);
        flightRepository.save(entity);
        return entity;
        
    }

}