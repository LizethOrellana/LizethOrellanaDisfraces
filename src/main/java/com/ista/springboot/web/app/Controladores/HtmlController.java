package com.ista.springboot.web.app.Controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ista.springboot.web.app.Modelo.AlquilerDisfraz;
import com.ista.springboot.web.app.Modelo.Cliente;
import com.ista.springboot.web.app.Modelo.Disfraz;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class HtmlController {
   List<Cliente> clientes= new ArrayList<>();
   List<Disfraz> disfraces= new ArrayList<>();
   List<AlquilerDisfraz> alquileres= new ArrayList<>();
   String cedula="";
   String codigo="";
   
	@GetMapping("/Menu")
    public String ejemplo(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "Menu";
    }
	
	@GetMapping("/Clientes")
    public String ejemplo2(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "Clientes";
    }

	@GetMapping("/Alquiler")
    public String ejemplo4(Model model) {
        model.addAttribute("clientes", clientes );
        model.addAttribute("disfraces", disfraces );
        return "Alquiler";
    }
	
	@GetMapping("/TablaClientes")
    public String ejemplo5(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "TablaClientes";
    }
	
	@GetMapping("/TablaDisfraces")
    public String ejemplo8(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "TablaDisfraces";
    }
	
	@PostMapping("/GuardarClientes")
	public String guardarClientes(Model model,@RequestParam String cedula, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String direccion, @RequestParam String estado) {
		boolean est=true;
		if(estado.equalsIgnoreCase("activo")) {
			est=true;
		}else if(estado.equalsIgnoreCase("inactivo")) {
			est=false;
		}
		Cliente  cliente = new Cliente();
		int total =clientes.size()+1;
		
		cliente.setId_cliente( (long) total);
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setDireccion(direccion);
		cliente.setEstado(est);
		clientes.add(cliente);
		model.addAttribute("clientes", clientes);
		System.out.println("Cliente guardado "+cliente.getNombres()+clientes.size());
		return "redirect:/listarcliente";
	}
	
	@PostMapping("/pasarcliente")
	public String pasarcliente(Model model, @RequestBody Cliente cliente) {
	    boolean est=true;
	    if(cliente.getEstado().equals("activo")) {
	        est=true;
	    } else if(cliente.getEstado().equals("inactivo")) {
	        est=false;
	    }
	    int total =clientes.size()+1;
	    cliente.setId_cliente((long) total);
	    cliente.setEstado(est);
	    model.addAttribute("cliente", cliente);
	    model.addAttribute("cedula", cliente.getCedula());
	    model.addAttribute("nombres", cliente.getNombres());
	    model.addAttribute("apellidos", cliente.getApellidos());
	    model.addAttribute("direccion", cliente.getDireccion());
	    model.addAttribute("estado", cliente.getEstado());
	    return "EditarCliente";
	}

	
	@GetMapping("/editarcliente")
	public String editarCliente(Model model) {
	    return "EditarCliente";
	}
	
	@GetMapping("/listarcliente")
	public String listarClientes(Model model) {
	    model.addAttribute("clientes", clientes);
	    return "TablaClientes";
	}
	
	
	@GetMapping("/Disfraz")
    public String ejemplo3(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "Disfraz";
    }
	
	@PostMapping("/GuardarDisfraz")
	public String guardarDisfraz(Model model,@RequestParam String codigo, @RequestParam String descripcion, @RequestParam String precio, @RequestParam String tipo) {
	
		Disfraz disfraz= new Disfraz();
		int total =disfraces.size()+1;
		disfraz.setId_disfraz((long) total);
		disfraz.setCodigo(codigo);
		disfraz.setDescripcion(descripcion);
		disfraz.setPrecio(Integer.parseInt(precio));
		disfraz.setTipo(tipo);
		disfraces.add(disfraz);
		model.addAttribute("disfraces", disfraces);
		System.out.println("Disfraz guardado "+disfraz.getCodigo()+disfraces.size());
		return "redirect:/listardisfraz";
	}
	
	@GetMapping("/listardisfraz")
	public String listardisfraz(Model model) {
	    model.addAttribute("disfraces", disfraces);
	    return "TablaDisfraces";
	}
	

	@PostMapping("/GuardarAlquiler")
	public String guardarAlquiler(Model model,@RequestBody Long id_cliente, @RequestBody Long id_disfraz ,@RequestParam String fecha_prestamo, @RequestParam String fecha_devolucion, @RequestParam String comentarios_alquiler, @RequestParam String cantidad_disfraces) throws ParseException {
		AlquilerDisfraz alquiler= new AlquilerDisfraz();
		Cliente cli=new Cliente();
		Disfraz dis = new Disfraz();
		
		int pr=0;
		int cat=0;
		
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getId_cliente()==id_cliente) {
				cli.setId_cliente(clientes.get(i).getId_cliente());
				cli.setCedula(clientes.get(i).getCedula());
				cli.setNombres(clientes.get(i).getNombres());
				cli.setApellidos(clientes.get(i).getApellidos());
				cli.setDireccion(clientes.get(i).getDireccion());
				cli.setEstado(clientes.get(i).getEstado());
				cedula=clientes.get(i).getCedula();			}
		}
		for (int i = 0; i < disfraces.size(); i++) {
			if(disfraces.get(i).getId_disfraz()==id_disfraz) {
				dis.setId_disfraz(disfraces.get(i).getId_disfraz());
				dis.setCodigo(disfraces.get(i).getCodigo());
				dis.setDescripcion(disfraces.get(i).getDescripcion());
				dis.setPrecio(disfraces.get(i).getPrecio());
				dis.setTipo(disfraces.get(i).getTipo());
				pr=disfraces.get(i).getPrecio();
				codigo=disfraces.get(i).getCodigo();
			}
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date date = dateFormat.parse(fecha_prestamo);
		 java.util.Date date2 = dateFormat.parse(fecha_devolucion);
		 
		Long total2 =(long)alquileres.size()+1;	
		System.out.println("Id "+total2);
		int totalalquiler= pr*Integer.parseInt(cantidad_disfraces);
		
		alquiler.setId_alquiler((long)total2);
		System.out.println(alquiler.getId_alquiler());
		
		alquiler.setCliente(cli);
		alquiler.setDisfraz(dis);
		alquiler.setFecha_prestamo(date);
		alquiler.setFecha_devolucion(date2);
		alquiler.setCantidad_disfraces(Integer.parseInt(cantidad_disfraces));
		alquiler.setTotal_alquiler(totalalquiler);
		alquiler.setComentarios_alquiler(comentarios_alquiler);
		
		alquileres.add(alquiler);
		model.addAttribute("alquileres", alquileres);
		model.addAttribute("cedula", cedula);
		model.addAttribute("codigo", codigo);
		System.out.println("Codigo"+codigo+" Cedula: "+cedula+" Alquiler Guardado "+alquiler.getId_alquiler()+alquileres.size());
		return "redirect:/listaralquiler";
	}
	
	@GetMapping("/listaralquiler")
	public String listaralquiler(Model model) {
	    model.addAttribute("alquileres", alquileres);
	    model.addAttribute("codigo", codigo);
	    model.addAttribute("cedula", cedula);
	    return "TablaAlquiler";
	}
	
	@GetMapping("/TablaAlquiler")
    public String ejemplo9(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "TablaAlquiler";
    }
	
}
