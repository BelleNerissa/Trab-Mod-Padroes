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

	public void calcularDiaria(Usuario usuario) {
		listaDeQuartos.get(usuario).calculaValor();
	}

	public void checkIn(Usuario usuario,Quarto quarto) {
		Set<Usuario> usuarios = listaDeQuartos.keySet();
		if (usuarios.stream().count() < QUANTIDADE_DE_QUARTOS)
			listaDeQuartos.put(usuario, quarto);
		// else add lista de espera.
	}

	public double realizarFesta(Usuario usuario) {
		if (listaDeQuartos.get(usuario) instanceof Cone)
			return listaDeQuartos.get(usuario).calculaValor() * 1.40;
		else if (listaDeQuartos.get(usuario) instanceof ConeComVaranda)
			return listaDeQuartos.get(usuario).calculaValor() * 1.30;
		return 0;
	}
}