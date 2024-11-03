package entidades;

import java.util.Date;

import entidades.enums.Status;

public class Cliente {
	
	protected String nome;
	private String email;
	private String telefone;
	
	public Cliente() {
	}
	public Cliente(String nome,String email, String telefone) {
		super();
		this.nome = nome;
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
	 public Agendamento agendar(Date dataHora, Barbeiro barbeiro) {
	        System.out.println("Agendamento realizado para o cliente " + nome);
	        return new Agendamento(dataHora, Status.MARCANDO, barbeiro,this);
	 }
}
