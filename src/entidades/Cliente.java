package entidades;

import java.util.Date;

import entidades.enums.Status;

public class Cliente {
	
	private String nome;
	private String CPF;
	private String email;
	private String telefone;
	
	public Cliente() {
	}
	public Cliente(String nome, String CPF,String email, String telefone) {
		super();
		this.nome = nome;
		this.CPF = CPF;
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
	 public Agendamento agendar(Date dataHora, Barbeiro barbeiro) {
	        System.out.println("Agendamento realizado para o cliente " + nome);
	        return new Agendamento(dataHora, Status.MARCANDO, barbeiro,this);
	 }
}
