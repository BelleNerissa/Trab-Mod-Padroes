
public class SPA extends Decorator {
	
	private final Quarto quarto;
	
	public SPA(Quarto quarto) {
		this.quarto = quarto;
	}
	
	@Override
	public double calculaValor() {
		return quarto.calculaValor() + 120;
	}

	@Override
	public double calculaValorFesta() {
		return quarto.calculaValorFesta() + 120;
	}

	
	
}
