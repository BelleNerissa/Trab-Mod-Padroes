
public class Frigobar extends Decorator {
	
	private final Quarto quarto;
	public Frigobar(Quarto quarto) {
		this.quarto = quarto;
	}
	@Override
	public double calculaValor() {
		return quarto.calculaValor() + 40;
	}
	
}
