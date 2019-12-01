
public class Aplicacao {

	public static void main(String[] args) {
		FabricaDeQuartos f = new FabricaDeQuartos();  
		CozyCone hotel = CozyCone.INSTANCE;
		hotel.gerarPlaca();
		Usuario u1 = new Usuario("Thiago","12345");
		Usuario u2 = new Usuario("sas","112345");
		Usuario u3 = new Usuario("ia","112345");
		Quarto q1 = f.getQuarto(TipoCone.SIMPLES);
		q1 = new CafeDaManha(q1);
		q1 = new SPA(q1);
		q1 = new Frigobar(q1);
		
		Quarto  q2 = f.getQuarto(TipoCone.VARANDA);;
		hotel.checkIn(u1, q1);
		hotel.checkIn(u2, q2);
	
		
		System.out.println(hotel.quartosOcupados());
		System.out.println(hotel.checkOut(u1, 3));
		System.out.println(hotel.quartosOcupados());
		
        //um problema aqui quando faco o checkOut o usuario da lista de espera eh adicionado na lista de quartos porem se eu tentar fazer um checkOut 
		//deste que foi adicionado nao consigo(o valor da 0 como aqui embaixo) se conseguir resolver tmj!!
		
		
		System.out.println("ERRO AQUI");
		System.out.println(hotel.checkOut(u2, 2));
		
		//As festas tbm nao consegui mais de resto esta tudo ok eu acho...
	}

}
