package UnitariasTestController;


import TestDataBuilder.ProductoTestDataBuilder;
import static org.junit.Assert.*;
import org.junit.Test;
import com.ventas.model.Producto;


public class TestProductos {

    private static final String  NOMBRE 	= "Camiseta";
    private static final String  CODIGO 	= "0012";
    private static final Float   PRECIO 	= (float) 2500;
    private static final Float   EXISTENCIA = (float) 3;

	@Test
	public void crearProductoTest() {
		
		// arrange
		
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().
				conNombre(NOMBRE).conCodigo(CODIGO).conPrecio(PRECIO).conExistencia(EXISTENCIA);
		
		// act
		Producto producto = productoTestDataBuilder.build();		

		// assert
		assertEquals(NOMBRE, producto.getNombre());
		assertEquals(CODIGO, producto.getCodigo());
		assertEquals(PRECIO, producto.getPrecio());
		assertEquals(EXISTENCIA, producto.getExistencia());
		
	}

}
