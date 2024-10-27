package entidades;

public class Barbeiro {
	private String nome;
	private String CPF;
	private String email;
	private String telefone;
	
	public Barbeiro() {
	
	}
	
	public Barbeiro(String nome, String cPF, String email, String telefone) {
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}
	
	
}
