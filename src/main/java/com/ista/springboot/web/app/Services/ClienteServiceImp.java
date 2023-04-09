package com.ista.springboot.web.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.Modelo.Cliente;
import com.ista.springboot.web.app.Modelo.dao.IClienteDao;

@Service
public class ClienteServiceImp implements IClienteService{
	  @Autowired
	    private IClienteDao usuarioDao;

	    @Override
	    @Transactional(readOnly = true)
	    public List<Cliente> findAll() {
	        return (List<Cliente>) usuarioDao.findAll();
	    }

	    @Override
	    @Transactional
	    public Cliente save(Cliente c) {
	        return usuarioDao.save(c);
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Cliente findById(Integer id) {
	        return usuarioDao.findById(id).orElse(null);
	    }

		@Override
		public void delete(Integer id) {
	        usuarioDao.deleteById(id);		
		}




}
