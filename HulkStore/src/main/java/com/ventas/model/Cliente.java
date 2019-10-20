package com.ventas.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

 
    @NotNull(message = "Ingresar el NI")
    @Size(min = 1, max = 10, message = "Numero de Identificacion debe ser entre 1 y 10 digitos")
    private String numeroide;
    
    @NotNull(message = "Ingresar Nombres Completos")
    @Size(min = 1, max = 150, message = "Nombres Completos entre 1 y 150 caracteres")
    private String nombrescompletos;
    
    @Size(min = 1, max = 100, message = "Correo Electronico entre 1 y 100 caracteres")
    private String email;

    private Integer numeromovil;

    @OneToMany(mappedBy = "cliente")
    private Set<Factura> facturas;    
    
	public Cliente(Integer id, String numeroide, String nombrescompletos, String email, Integer numeromovil) {
		this.id = id;
		this.numeroide = numeroide;
		this.nombrescompletos = nombrescompletos;
		this.email = email;
		this.numeromovil = numeromovil;
	}
	
	
	public Cliente(String numeroide, String nombrescompletos, String email, Integer numeromovil) {
		this.numeroide = numeroide;
		this.nombrescompletos = nombrescompletos;
		this.email = email;
		this.numeromovil = numeromovil;
	}

	//public Cliente(@NotNull(message = "Ingresar Numero de Identificacion") @Size(min = 1, max = 10, message = "El Numero de Identificacion entre 1 y 10") String numeroide) {
	//        this.numeroide = numeroide;
	//    }
	
    
    public Cliente() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroide() {
		return numeroide;
	}

	public void setNumeroide(String numeroide) {
		this.numeroide = numeroide;
	}

	public String getNombrescompletos() {
		return nombrescompletos;
	}

	public void setNombrescompletos(String nombrescompletos) {
		this.nombrescompletos = nombrescompletos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeromovil() {
		return numeromovil;
	}

	public void setNumeromovil(Integer numeromovil) {
		this.numeromovil = numeromovil;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}


  

}
