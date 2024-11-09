package aplicacao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Agendamento;
import entidades.Barbeiro;
import entidades.Cliente;
import entidades.ClientePf;
import entidades.ClientePj;
import entidades.enums.Status;

public class Main {

	public static void main(String[] args) throws SQLException {
		Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdfSaida = new SimpleDateFormat("EEE dd/MMM yyyy HH:mm", new Locale("pt", "BR"));
        
        System.out.println("Cadastro do Barbeiro:");
        System.out.print("Nome: ");
        String nomeBarbeiro = sc.nextLine();
        System.out.print("CPF: ");
        String cpfBarbeiro = sc.nextLine();
        System.out.print("Email: ");
        String emailBarbeiro = sc.nextLine();
        System.out.print("Telefone: ");
        String telefoneBarbeiro = sc.nextLine();
        Barbeiro barbeiro = new Barbeiro(nomeBarbeiro, cpfBarbeiro, emailBarbeiro, telefoneBarbeiro);
        barbeiro.salvar();
        
        
        System.out.println("Cadastro do Cliente:");
        System.out.println("o cliente é Pessoa física ou juridica:(PF/Pj)");
        String identificacao=sc.nextLine();
        Cliente cliente;
        if (identificacao.equals("Pf")) {
	        System.out.print("Nome: ");
	        String nomeClientepf = sc.nextLine();
	        System.out.print("Email: ");
	        String emailClientepf = sc.nextLine();
	        System.out.print("Telefone: ");
	        String telefoneClientepf = sc.nextLine();
	        System.out.print("CPF: ");
	        String cpfCliente = sc.nextLine();
	        cliente = new ClientePf(nomeClientepf, emailClientepf, telefoneClientepf, cpfCliente);
        }
	     else {
	     	System.out.print("Nome: ");
	        String nomeClientepj = sc.nextLine();
	        System.out.print("Email: ");
	        String emailClientepj = sc.nextLine();
	        System.out.print("Telefone: ");
	        String telefoneClientepj = sc.nextLine();
	        System.out.print("CPF: ");
	        String cnpjCliente = sc.nextLine();
	        cliente = new ClientePj(nomeClientepj, emailClientepj, telefoneClientepj, cnpjCliente);
        }
        cliente.salvar();
        //Tratamento data e hora para o agendamento
        Date dataHora = null;
        boolean dataValida;
        do {
            System.out.println("Informe a data e hora do agendamento (dd/MM/yyyy HH:mm): ");
            String entrada = sc.nextLine();
            try {
                dataHora = sdf.parse(entrada);
                dataValida = true; 
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
                dataValida = false; 
            }
        } while (!dataValida);        
        
        Agendamento agendamento = cliente.agendar(dataHora, barbeiro);
        // Atualiza o status e salva no banco
        agendamento.setStatus(Status.CONFIRMADO);
        Agendamento.exibirDetalhesAgendamento(agendamento, sdfSaida);
        agendamento.salvar();
        
        sc.close();
	}

}
