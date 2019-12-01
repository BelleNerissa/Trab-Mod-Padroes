
public class SPA extends Decorator {
	
	private final Quarto quarto;
	
	public SPA(Quarto quarto) {
		this.quarto = quarto;
	}
	
	@Override
	public int calculaValor() {
		return quarto.calculaValor() + 120;
	}
	
}
