import static org.junit.jupiter.api.Assertions.
*;
import org.junit.jupiter.api.Test;

class CozyConeTest {
    CozyCone hotel = CozyCone.INSTANCE;
	static FabricaDeQuartos f = new FabricaDeQuartos(); 
	
	@Test
	void testQuartosOcupados() {
		Usuario u2 = new Usuario("Thiago","12345");
		Quarto q2 = f.getQuarto(TipoCone.VARANDA);
		q2 = new CafeDaManha(q2);
		q2 = new SPA(q2);
		q2 = new Frigobar(q2);
		hotel.checkIn(u2, q2);
		assertEquals(1,hotel.quartosOcupados());
	}

	@Test 
	void testCheckIn() {
		Usuario u1 = new Usuario("Maria","12345");
		Quarto q1 = f.getQuarto(TipoCone.SIMPLES);
		q1 = new CafeDaManha(q1);
		q1 = new SPA(q1);
		hotel.checkIn(u1, q1);
		assertTrue(hotel.temReserva(u1));
	}
	
	@Test
	void testCheckOut() {
		Usuario u3 = new Usuario("Luis","12345");
		Quarto q3 = f.getQuarto(TipoCone.VARANDA);
		q3 = new CafeDaManha(q3);
		q3 = new SPA(q3);
		q3 = new Frigobar(q3);
		hotel.checkIn(u3, q3);
		assertEquals(2586.0,hotel.checkOut(u3, 3, 1));
		assertFalse(hotel.temReserva(u3));
	}
	
	
	
	
	
	
}
