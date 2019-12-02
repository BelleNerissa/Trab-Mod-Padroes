import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuartoTest {
	FabricaDeQuartos f = new FabricaDeQuartos();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculaDiariaSemServicos() {
		Quarto q = f.getQuarto(TipoCone.SIMPLES);
		assertEquals(480,q.calculaValor());
		Quarto q1 = f.getQuarto(TipoCone.VARANDA);
		assertEquals(620,q1.calculaValor());
	}
	
	@Test
	void testCalculaDiariaComFesta() {
		Quarto q = f.getQuarto(TipoCone.SIMPLES);
		assertEquals(672,q.calculaValorFesta());
		Quarto q1 = f.getQuarto(TipoCone.VARANDA);
		assertEquals(806,q1.calculaValorFesta());
	}
	
	@Test
	void testCalculaDiariaComServicos() {
		Quarto q = f.getQuarto(TipoCone.SIMPLES);
		q = new CafeDaManha(q);
		assertEquals(500,q.calculaValor());
		Quarto q1 = f.getQuarto(TipoCone.VARANDA);
		q1 = new CafeDaManha(q1);
		q1 = new SPA(q1);
		q1 = new Frigobar(q1);
		assertEquals(800,q1.calculaValor());
	}

}
