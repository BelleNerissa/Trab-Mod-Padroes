
public class Aplicacao {

	public static void main(String[] args) {
		FabricaDeQuartos f = new FabricaDeQuartos();  
		CozyCone hotel = CozyCone.INSTANCE;
		Usuario u1 = new Usuario("Thiago","12345");
		Usuario u2 = new Usuario("Thiagoo","112345");
		Usuario u3 = new Usuario("Thiagooo","112345");
		Quarto q1 = f.getQuarto(TipoCone.SIMPLES);
		q1 = new CafeDaManha(q1);
		q1 = new SPA(q1);
		q1 = new Frigobar(q1);
		
		Quarto  q2 = f.getQuarto(TipoCone.VARANDA);
		hotel.checkIn(u1, q1);
		hotel.checkIn(u2, q2);
		System.out.println(hotel.calcularDiaria(u1));
		System.out.println(hotel.calcularDiaria(u2));
		System.out.println(hotel.checkOut(u1, 2));
		System.out.println(hotel.realizarFesta(u1));
	}

}
