import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CozyCone {
	public static final CozyCone INSTANCE = new CozyCone();
	public static final int QUANTIDADE_DE_QUARTOS = 20;

	private ListaDeEspera listaDeEspera;
	private Map<Usuario, Quarto> listaDeQuartos = new LinkedHashMap<Usuario, Quarto>();
	private List<String> a;

	public CozyCone getInstance() {
		return INSTANCE;
	}

	private CozyCone() {

	}

	public void update() {

	}

	public long quartosOcupados() {
		Set<Usuario> usuarios = listaDeQuartos.keySet();
		return usuarios.stream().count();
	}

	public double calcularDiaria(Usuario usuario) {
		return listaDeQuartos.get(usuario).calculaValor();
	}

	public void checkIn(Usuario usuario, Quarto quarto) {
		if (this.quartosOcupados() < QUANTIDADE_DE_QUARTOS)
			listaDeQuartos.put(usuario, quarto);
		// else add lista de espera.
	}

	public double checkOut(Usuario usuario, int dias) {
		if (listaDeQuartos.get(usuario) != null) {
			double diaria = listaDeQuartos.get(usuario).calculaValor();
			listaDeQuartos.remove(usuario);
			return diaria * dias;
			// avisar e add lista de espera.
		} else
			return 0;
	}

	public double realizarFesta(Usuario usuario) {
		if (listaDeQuartos.get(usuario) instanceof Cone)
			return this.calcularDiaria(usuario) * 1.40;
		else if (listaDeQuartos.get(usuario) instanceof ConeComVaranda)
			return this.calcularDiaria(usuario) * 1.30;
		return 0;
	}

}
