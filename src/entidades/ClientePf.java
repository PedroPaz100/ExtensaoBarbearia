package entidades;

import java.util.Date;

import entidades.enums.Status;

public class ClientePf extends Cliente {
	
	private String cpf;
	

	public ClientePf() { 
    }
    public ClientePf(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);
        this.cpf = cpf;
    }
    public String getIdentificacao() {
        return cpf;
    }
    @Override
    public Agendamento agendar(Date dataHora, Barbeiro barbeiro) {
        System.out.println("Agendamento realizado para o cliente " + nome);
        return new Agendamento(dataHora, Status.MARCANDO, barbeiro,this);
 }
}
