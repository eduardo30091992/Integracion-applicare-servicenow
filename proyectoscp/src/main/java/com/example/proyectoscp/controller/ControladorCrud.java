package com.example.proyectoscp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;

import com.example.proyectoscp.model.EmpresaCrud;
import com.example.proyectoscp.model.empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value={"/"})
public class ControladorCrud {
	@Autowired(required=true)
    private EmpresaCrud ec;
	
	@RequestMapping(value={"login"}, method = RequestMethod.GET)
	public ModelAndView login(ModelMap mp){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value={"empresas"}, method = RequestMethod.GET)
	public ModelAndView empresa(ModelMap mp){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("empresas");
		mp.put("empresas", ec.findAll());
		return modelAndView;
	}
    
	@RequestMapping(value="/empresa/da", method=RequestMethod.POST)
	public @ResponseBody empresa add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		empresa employee = new empresa();
		long id = 1;
		String nombre = request.getParameter("nombre");
		String dir = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String contacto = request.getParameter("contacto");
		employee.setId(id);
		employee.setNombre(nombre);
		employee.setDireccion(dir);
		employee.setTelefono(telefono);
		employee.setContacto(contacto);
		return employee;
	}
	@RequestMapping(value="/empresa/d", method=RequestMethod.POST)
	@ResponseBody
	public Object aa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		empresa employee = new empresa();
		long id = 1;
		String nombre = request.getParameter("nombre");
		String dir = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String contacto = request.getParameter("contacto");
		/*employee.setId(id);
		employee.setNombre(nombre);
		employee.setDireccion(dir);
		employee.setTelefono(telefono);
		employee.setContacto(contacto);*/
		ArrayList<String> a = new ArrayList<String>();
		a.add(nombre);
		a.add(dir);
		a.add(telefono);
		a.add(contacto);
		a.add("SUCCES");
		return a;
	}
	@RequestMapping(value="/empresa/save", method=RequestMethod.POST)
	@ResponseBody
	public Object empresaGuardar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nombre = request.getParameter("nombre");
		String dir = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String contacto = request.getParameter("contacto");
		
		empresa dato = new empresa();
		dato.setNombre(nombre);
		dato.setDireccion(dir);
		dato.setTelefono(telefono);
		dato.setContacto(contacto);
		ec.save(dato);

		ArrayList<String> a = new ArrayList<String>();
		a.add(nombre);
		a.add(dir);
		a.add(telefono);
		a.add(contacto);
		a.add("SUCCES");
		return a;
	}
	@RequestMapping(value={"/empresa/delete"}, method = RequestMethod.POST)
	@ResponseBody
	public Object empresadelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		long id = Long.parseLong(request.getParameter("id"));
		ec.deleteById(id);
		ArrayList<String> a = new ArrayList<String>();
		a.add("SUCCES");
		return a;
		
	}
	@RequestMapping(value={"guardar"}, method = RequestMethod.GET)
	public String guardar(){
		/*
		    //INSERT
			empresa dato = new empresa();
			dato.setNombre("sadf");
			dato.setDireccion("asfd");
			dato.setTelefono("1243");
			dato.setContacto("asdf");
			ec.save(dato);*/
		//UPDATE
		//ec.updateUser("juan", "pedro", "pablo", "fernando", 4);
		
		//DELETE
		long id = 5;
		ec.deleteById(id);

		return "GUARDADO";
	}
	@RequestMapping(value={"consulta"}, method = RequestMethod.GET)
	public Object consultaid(){
		
		//RECORRER Y OBTENER SOLO 1 VALOR
		//long a = 6;
		//return ec.findById(a);
		
		//RECORRE Y MOSTRAR TODOS LOS VALORES
		return ec.findAll();
		
	}
	
	
}
