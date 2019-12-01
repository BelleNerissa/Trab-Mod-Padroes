import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CozyCone {

	public static final CozyCone INSTANCE = new CozyCone();
	public static final int QUANTIDADE_DE_QUARTOS = 1;
	private ListaDeEspera listaDeEspera = new ListaDeEspera();
	
	private Map<Usuario,Quarto> mapEspera = new LinkedHashMap<Usuario,Quarto>();
	private Map<Usuario, Quarto> listaDeQuartos = new LinkedHashMap<Usuario, Quarto>();

	public CozyCone getInstance() {
		return INSTANCE;
	}
	

	public void gerarPlaca() {
		new PlacaObserver(listaDeEspera);
		listaDeEspera.setState(1);
	}

	
	

	private CozyCone() {

	}

	public long quartosOcupados() {
		Set<Usuario> usuarios = listaDeQuartos.keySet();
		return usuarios.stream().count();
	}

	private double calcularDiaria(Usuario usuario) {
		return listaDeQuartos.get(usuario).calculaValor();
	}

	public void checkIn(Usuario usuario, Quarto quarto) {
		if (this.quartosOcupados() < QUANTIDADE_DE_QUARTOS)
			listaDeQuartos.put(usuario, quarto);
		else {
			this.addListaDeEspera(usuario, quarto);
			listaDeEspera.setState(0);
		}
	}
	
	private void addListaDeEspera(Usuario usuario, Quarto quarto) {
		mapEspera.put(usuario, quarto);
		new Usuario(usuario.getNome(), usuario.getCpf(), listaDeEspera);
	} 
	

	public double checkOut(Usuario usuario, int dias) {
		if (listaDeQuartos.get(usuario) != null) {
			double diaria = this.calcularDiaria(usuario);
			listaDeQuartos.remove(usuario);
			if (this.quartosOcupados() == (QUANTIDADE_DE_QUARTOS - 1) && !mapEspera.isEmpty()) {
				listaDeEspera.setState(1);
				this.removeListaDeEspera();
				listaDeEspera.setState(0);
			} else
				listaDeEspera.setState(1);
			return diaria * dias;
		} else
			return 0;
	}
	
	private void removeListaDeEspera() {
		listaDeEspera.removeObserver();
		Set<Usuario> s = mapEspera.keySet();
		List<Usuario> l = new ArrayList<Usuario>();
		for(Usuario u: s) {
			l.add(u);
		}
		listaDeQuartos.put(l.remove(0), mapEspera.remove(s));
	}

	public double realizarFesta(Usuario usuario) {
		if (listaDeQuartos.get(usuario) instanceof Cone)
			return this.calcularDiaria(usuario) * 1.40;
		else if (listaDeQuartos.get(usuario) instanceof ConeComVaranda)
			return this.calcularDiaria(usuario) * 1.30;
		return 0;
	}

}
