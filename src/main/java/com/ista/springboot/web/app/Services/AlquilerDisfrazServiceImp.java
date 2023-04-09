package com.ista.springboot.web.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.Modelo.AlquilerDisfraz;
import com.ista.springboot.web.app.Modelo.Disfraz;
import com.ista.springboot.web.app.Modelo.dao.IAlquilerDisfrazDao;
import com.ista.springboot.web.app.Modelo.dao.IDisfrazDao;
@Service
public class AlquilerDisfrazServiceImp implements IAlquilerDisfrazService {
	@Autowired
    private IAlquilerDisfrazDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<AlquilerDisfraz> findAll() {
        return (List<AlquilerDisfraz>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public AlquilerDisfraz save(AlquilerDisfraz c) {
        return usuarioDao.save(c);
    }

    @Override
    @Transactional(readOnly = true)
    public AlquilerDisfraz findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

	@Override
	public void delete(Integer id) {
        usuarioDao.deleteById(id);		
	}
}
