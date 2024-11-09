package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import aplicacao.Bda;
import entidades.enums.Status;

public class ClientePf extends Cliente {
	
	private String cpf;
	

	public ClientePf() { 
    }
	public ClientePf(String nome, String email, String telefone, String cpf) {
	    super(nome, email, telefone, "PF");
	    this.cpf = cpf;
	}
	@Override
    public String getIdentificacao() {
        return cpf;
    }
	 @Override
	    public void salvar() throws SQLException {
	        // insere os dados básicos (nome, email, telefone, tipo)
	        super.salvar();

	        // Salva os dados específicos de ClientePf 
	        String sql = "INSERT INTO ClientePf (cpf) VALUES (?)";

	        try (Connection conn = Bda.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            stmt.setString(1, cpf);
	            stmt.executeUpdate();
	            System.out.println("Cliente Pessoa Física salvo com sucesso!");
	        }
	    }
    @Override
    public Agendamento agendar(Date dataHora, Barbeiro barbeiro) {
        System.out.println("Agendamento realizado para o cliente " + nome);
        return new Agendamento(dataHora, Status.MARCANDO, barbeiro,this);
 }
}
