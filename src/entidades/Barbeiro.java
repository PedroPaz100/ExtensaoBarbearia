package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import aplicacao.Bda;

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
	// Método para salvar no Banco
	 public void salvar() {
	        String sql = "INSERT INTO Barbeiro (cpf, nome, email, telefone) VALUES (?, ?, ?, ?)";
	        
	        try (Connection conn = Bda.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            stmt.setString(1, CPF);
	            stmt.setString(2, nome);
	            stmt.setString(3, email);
	            stmt.setString(4, telefone);
	            
	            stmt.executeUpdate();
	            System.out.println("Barbeiro cadastrado com sucesso!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
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
