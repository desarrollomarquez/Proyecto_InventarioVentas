package TestDataBuilder;

import java.util.Set;
import com.ventas.model.Factura;
import com.ventas.model.Producto;
import com.ventas.model.Cliente;

public class ProductoTestDataBuilder {
	
	
    private static final String  NOMBRE 	= "Camiseta";
    private static final String  CODIGO 	= "0012";
    private static final Float   PRECIO 	= (float) 2500;
    private static final Float   EXISTENCIA = (float) 3; 
    
    private String   nombre;
    private String   codigo;
    private Float    precio;
    private Float    existencia;



	public ProductoTestDataBuilder() {
		this.nombre = NOMBRE;
		this.codigo = CODIGO;
		this.precio = PRECIO;
		this.existencia = EXISTENCIA;
	}

	public ProductoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProductoTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public ProductoTestDataBuilder conPrecio(Float precio) {
		this.precio = precio;
		return this;
	}
	
	public ProductoTestDataBuilder conExistencia(Float existencia) {
		this.existencia = existencia;
		return this;
	}
	
	public Producto build() {
		return new Producto(this.nombre, this.codigo, this.precio, this.existencia);
	}
}
