package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import aplicacao.Bda;
import entidades.enums.Status;

public class Cliente {
	
	protected String nome;
	protected String email;
	protected String telefone;
	protected String tipo;
	
	public Cliente() {
	}
	public Cliente(String nome, String email, String telefone, String tipo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    public void salvar() throws SQLException {
        String sql = "INSERT INTO Cliente (cpf_cnpj, nome, email, telefone, tipo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Bda.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, getIdentificacao());  
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, tipo);

            stmt.executeUpdate();
            System.out.println("Dados básicos do cliente salvos com sucesso!");
        }
    }

    // Método para obter CPF ou CNPJ - será implementado nas subclasses
    public String getIdentificacao() {
        return null; // Esse método é sobrescrito nas subclasses
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
