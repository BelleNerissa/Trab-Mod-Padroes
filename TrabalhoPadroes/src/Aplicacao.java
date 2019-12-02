

public class Aplicacao {

	public static void main(String[] args) {
		FabricaDeQuartos f = new FabricaDeQuartos();  
		CozyCone hotel = CozyCone.INSTANCE;
		hotel.gerarPlaca();
		Usuario u1 = new Usuario("Thiago","123441235");
		Usuario u2 = new Usuario("Maria","1123442135");
		Usuario u3 = new Usuario("Luis","1123441235");
		Usuario u4 = new Usuario("Warley","1123441325");
		Usuario u5 = new Usuario("Marcos","1123143245");
		Usuario u6 = new Usuario("Larissa","1132345");

		System.out.println(hotel.quartosOcupados());
		
		Quarto q1 = f.getQuarto(TipoCone.SIMPLES);
		q1 = new CafeDaManha(q1);
		q1 = new SPA(q1);
		q1 = new Frigobar(q1);
		
		Quarto  q2 = f.getQuarto(TipoCone.VARANDA);
		q2 = new CafeDaManha(q1);
		q2 = new SPA(q1);
		q2 = new Frigobar(q1);
		
		Quarto  q3 = f.getQuarto(TipoCone.SIMPLES);
		q3 = new CafeDaManha(q1);
		
		Quarto  q4 = f.getQuarto(TipoCone.VARANDA);
		
		Quarto  q5 = f.getQuarto(TipoCone.VARANDA);
		
		Quarto  q6 = f.getQuarto(TipoCone.SIMPLES);
		
		  
		
		hotel.checkIn(u1, q1);
		hotel.checkIn(u2, q2);
		hotel.checkIn(u3, q3);
		hotel.checkIn(u4, q4);
		hotel.checkIn(u5, q5);
		hotel.checkIn(u6, q6);
	
		
		
		System.out.println(hotel.quartosOcupados());
		System.out.println(hotel.checkOut(u1,2,1));
		System.out.println(hotel.quartosOcupados());

	}

}
