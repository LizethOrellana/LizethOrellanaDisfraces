package com.ista.springboot.web.app.Modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "disfraz")
public class Disfraz implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disfraz;
	private String codigo;
	private String descripcion;
	private Integer precio;
	private String tipo;
	
	
	
	public Disfraz(Long id_disfraz, String codigo, String descripcion, Integer precio, String tipo) {
		super();
		this.id_disfraz = id_disfraz;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	
	public Disfraz() {
	}


	public Long getId_disfraz() {
		return id_disfraz;
	}
	public void setId_disfraz(Long id_disfraz) {
		this.id_disfraz = id_disfraz;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
