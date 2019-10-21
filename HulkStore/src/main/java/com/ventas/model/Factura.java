package com.ventas.model;

import javax.persistence.*;

import com.ventas.util.Utiles;

import java.util.Set;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fechaYHora;

    @OneToMany(mappedBy = "factura")
    private Set<Detalle> detalles;
    
    
	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	    
    
    public Factura() {
        this.fechaYHora = Utiles.obtenerFechaYHoraActual();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotal() {
        Float total = 0f;
        for (Detalle productoVendido : this.detalles) {
            total += productoVendido.getTotal();
        }
        return total;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }


	public Set<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    
    
}
