package com.ista.springboot.web.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ista.springboot.web.app.Modelo.Cliente;

@Service
public interface IClienteService {
	public List<Cliente> findAll();

    public Cliente  save(Cliente c);
    
    public Cliente findById(Integer id);


    public void delete(Integer id);
}
