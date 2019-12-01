
public class PlacaObserver extends Observer {

	public PlacaObserver(ListaDeEspera subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		if(subject.getState() == 1)
			System.out.println("Vagas Disponiveis!!!");
		else if(subject.getState() == 0)
			System.out.println("Sem vagas disponiveis!!!");
	}

}
