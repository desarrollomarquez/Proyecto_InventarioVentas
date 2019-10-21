package TestDataBuilder;

import java.util.Set;
import com.ventas.model.Factura;
import com.ventas.model.Cliente;

public class ClienteTestDataBuilder {
	
	
    private static final String  NI = "123456";
    private static final String  NC = "Juan Perez";
    private static final String  E= "Juan@gmail.com";
    private static final int    MOVIL = 311232113;
    //private static final Set<Factura> FACTURAS;    
    
    private String  numeroide;
    private String  nombrescompletos;
    private String  email;
    private int     numeromovil;
    private Set<Factura> facturas;    


	public ClienteTestDataBuilder() {
		this.numeroide = NI;
		this.nombrescompletos = NC;
		this.email = E;
		this.numeromovil = MOVIL;
	}

	public ClienteTestDataBuilder conNumeroide(String numeroide) {
		this.numeroide = numeroide;
		return this;
	}

	public ClienteTestDataBuilder conNombreCompleto(String nombrescompletos) {
		this.nombrescompletos = nombrescompletos;
		return this;
	}

	public ClienteTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ClienteTestDataBuilder conMovil(int numeromovil) {
		this.numeromovil = numeromovil;
		return this;
	}
	
	public Cliente build() {
		return new Cliente(this.numeroide, this.nombrescompletos, this.email, this.numeromovil);
	}
}
