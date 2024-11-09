package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import aplicacao.Bda;
import entidades.enums.Status;

public class ClientePj extends Cliente{
    private String cnpj;

    public ClientePj() { 
    }
    public ClientePj(String nome, String email, String telefone, String cnpj) {
        super(nome, email, telefone, "PJ");
        this.cnpj = cnpj;
    }
    @Override
	public String getIdentificacao() {
        return cnpj;
    }
    @Override
    public void salvar() throws SQLException {
        // insere os dados básicos (nome, email, telefone, tipo)
        super.salvar();

        // Salva os dados específicos de ClientePj 
        String sql = "INSERT INTO ClientePj (cnpj) VALUES (?)";

        try (Connection conn = Bda.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cnpj);
            stmt.executeUpdate();
            System.out.println("Cliente Pessoa Jurídica salvo com sucesso!");
        }
    }
    @Override
    public Agendamento agendar(Date dataHora, Barbeiro barbeiro) {
        System.out.println("Agendamento realizado para o cliente " + nome);
        return new Agendamento(dataHora, Status.MARCANDO, barbeiro,this);
 }
}
