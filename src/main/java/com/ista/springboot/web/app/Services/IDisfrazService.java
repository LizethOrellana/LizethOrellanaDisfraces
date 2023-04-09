package com.ista.springboot.web.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ista.springboot.web.app.Modelo.Disfraz;
@Service
public interface IDisfrazService {
	public List<Disfraz> findAll();

    public Disfraz  save(Disfraz c);
    
    public Disfraz findById(Integer id);


    public void delete(Integer id);
}
