import java.util.Scanner;

public class Usuario extends Observer {
	private String nome;
	private String cpf;
	Scanner sc = new Scanner(System.in);

	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Usuario(String nome, String cpf, ListaDeEspera subject) {
		this.nome = nome;
		this.cpf = cpf;
		this.subject = subject;
		this.subject.attach(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public void update() {
		if (subject.getState() == 1) {
			System.out.println(this.getNome() + " Agora ha vagas disponiveis no CozyCone!");
			System.out.println("Pressione Qualquer tecla para continuar");
			sc.nextLine();
		} else if (subject.getState() == 0) {
			System.out.println(this.getNome() + " Desculpe nao temos mais vagas");
			System.out.println("Pressione Qualquer tecla para continuar");
			sc.nextLine();
		}
	}

}
