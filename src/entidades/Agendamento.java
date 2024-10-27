package entidades;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import entidades.enums.Status;

public class Agendamento {
	public Date dataHora;
	public Status status;
	public Barbeiro barbeiro;
	public Cliente cliente;
	
	public Agendamento() {	
	}
	public Agendamento(Date dataHora, Status status, Barbeiro barbeiro, Cliente cliente) {
		this.dataHora = dataHora;
		this.status = status ;
		this.barbeiro = barbeiro;
		this.cliente = cliente;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Barbeiro getBarbeiro() {
		return barbeiro;
	}
	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	SimpleDateFormat sdfSaida = new SimpleDateFormat("EEE dd/MMM yyyy HH:mm", new Locale("pt", "BR"));
	public static void exibirDetalhesAgendamento(Agendamento agendamento, SimpleDateFormat sdfSaida) {
		System.out.println("Data e Hora: " + sdfSaida.format(agendamento.getDataHora()));
        System.out.println("Status: " + agendamento.getStatus());
        System.out.println("Barbeiro: " + agendamento.getBarbeiro().getNome());
        System.out.println("Cliente: " + agendamento.getCliente().getNome());
    }
	
}
