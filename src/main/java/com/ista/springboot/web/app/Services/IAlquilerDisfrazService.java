package com.ista.springboot.web.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ista.springboot.web.app.Modelo.AlquilerDisfraz;

@Service
public interface IAlquilerDisfrazService {
	public List<AlquilerDisfraz> findAll();

    public AlquilerDisfraz  save(AlquilerDisfraz c);
    
    public AlquilerDisfraz findById(Integer id);


    public void delete(Integer id);
}
