package com.example.proyectoscp.model;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.proyectoscp.model.empresa;

@Repository
public interface EmpresaCrud extends CrudRepository<empresa,Long> {
	@Transactional
    @Modifying
    @Query(value = "UPDATE empresa SET nombre =:nombre, direccion=:direccion, telefono=:telefono, contacto=:contacto where id = :id",
            nativeQuery = true)
public void updateUser(@Param(value="nombre") String nombre, @Param("direccion") String direccion,  @Param("telefono") String telefono, @Param("contacto") String contacto, @Param("id") int id);
}
