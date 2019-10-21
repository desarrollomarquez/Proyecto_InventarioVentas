package UnitariasTestController;

import TestDataBuilder.ClienteTestDataBuilder;
import static org.junit.Assert.*;
import org.junit.Test;
import com.ventas.model.Cliente;


public class TestClientes {

    private static final String  NID = "123456";
    private static final String  NCOMPLETO = "Juan Perez";
    private static final String  EMAIL= "Juan@gmail.com";
    private static final Integer NMOVIL = 311232113;

	@Test
	public void crearClienteTest() {
		
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().
				conNumeroide(NID).
				conNombreCompleto(NCOMPLETO).
				conEmail(EMAIL).
				conMovil(NMOVIL);

		// act
		Cliente cliente = clienteTestDataBuilder.build();
		
		// assert
		assertEquals(NID, cliente.getNumeroide());
		assertEquals(NCOMPLETO, cliente.getNombrescompletos());
		assertEquals(EMAIL, cliente.getEmail());
		assertEquals(NMOVIL, cliente.getNumeromovil());
		
	}
	
	

}
