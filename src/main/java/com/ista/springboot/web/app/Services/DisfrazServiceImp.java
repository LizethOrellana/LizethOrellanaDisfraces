package com.ista.springboot.web.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.Modelo.Disfraz;
import com.ista.springboot.web.app.Modelo.dao.IDisfrazDao;

@Service
public class DisfrazServiceImp implements IDisfrazService{
	@Autowired
    private IDisfrazDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Disfraz> findAll() {
        return (List<Disfraz>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public Disfraz save(Disfraz c) {
        return usuarioDao.save(c);
    }

    @Override
    @Transactional(readOnly = true)
    public Disfraz findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

	@Override
	public void delete(Integer id) {
        usuarioDao.deleteById(id);		
	}
}
