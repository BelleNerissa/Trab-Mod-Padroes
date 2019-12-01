
public class FabricaDeQuartos {
	
	public Quarto getQuarto(TipoCone cone) {
		if(cone == null)
			return null;
		else if (cone.equals(TipoCone.SIMPLES))
			return new Cone();
		else if(cone.equals(TipoCone.VARANDA))
			return new ConeComVaranda();
		return null;
	}
}
