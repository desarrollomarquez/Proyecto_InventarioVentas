package IntegrationTestController;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ventas.controller.ClientesController;
import com.ventas.model.Cliente;
import TestDataBuilder.ClienteTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = IntTestClientes.class
)

public class IntTestClientes {
	
	 @Autowired
	 private WebApplicationContext wac;

	 private MockMvc mockMvc;
	 
	 ClientesController clientesController = new ClientesController(); 
	 BindingResult      bindingResult;
	 RedirectAttributes redirectAttrs;
	 
	 private static final String  GUARDADO   = "redirect:/clientes/agregar";
	 private static final String  NOGUARDADO = "clientes/agregar_cliente";
	 private static final String  NID = "123456";
	 private static final String  NCOMPLETO = "Juan Perez";
	 private static final String  EMAIL= "Juan@gmail.com";
	 private static final int     NMOVIL = 311232113;
	
	 @Before
	 public void setUp() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	 }

	 @Test
		public void guardarClienteTest() {

			// arrange
			Cliente cliente = new ClienteTestDataBuilder()
					.conNumeroide(NID)
					.conNombreCompleto(NCOMPLETO)
					.conEmail(EMAIL)
					.conMovil(NMOVIL)
					.build();
			
				
			// act

			
		//	String esperado = clientesController.guardarCliente(cliente, bindingR, redirectAttrs);
			
			// assert
		//	System.out.print("guardarClienteTest : "+ esperado +"\n");
			//Assert.assertEquals(NOGUARDADO, esperado);

		}
	 
	 
	 
}
