
public class CafeDaManha extends Decorator{
	private final Quarto quarto;
	
	public CafeDaManha(Quarto quarto){
		this.quarto = quarto;
	}

	@Override
	public int calculaValor() {
		return quarto.calculaValor() +20;
	}
}
