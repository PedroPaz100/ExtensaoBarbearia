package entidades;

import java.util.Date;

import entidades.enums.Status;

public class ClientePj extends Cliente{
    private String cnpj;

    public ClientePj() { 
    }
    public ClientePj(String nome, String email, String telefone, String cnpj) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }
	public String getIdentificacao() {
        return cnpj;
    }
    @Override
    public Agendamento agendar(Date dataHora, Barbeiro barbeiro) {
        System.out.println("Agendamento realizado para o cliente " + nome);
        return new Agendamento(dataHora, Status.MARCANDO, barbeiro,this);
 }
}
