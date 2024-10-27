package aplicacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Agendamento;
import entidades.Barbeiro;
import entidades.Cliente;
import entidades.enums.Status;

public class Main {

	public static void main(String[] args) {
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
        
        System.out.println("Cadastro do Cliente:");
        System.out.print("Nome: ");
        String nomeCliente = sc.nextLine();
        System.out.print("CPF: ");
        String cpfCliente = sc.nextLine();
        System.out.print("Email: ");
        String emailCliente = sc.nextLine();
        System.out.print("Telefone: ");
        String telefoneCliente = sc.nextLine();
        Cliente cliente = new Cliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente);
        
        //Tratamento data e hora para o agendamento
        Date dataHora = null;
        boolean dataValida;
        do {
            System.out.println("Informe a data e hora do agendamento (dd/MM yyyy HH:mm): ");
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
        // Atualiza o status
        agendamento.setStatus(Status.CONFIRMADO);
        Agendamento.exibirDetalhesAgendamento(agendamento, sdfSaida);
        
        
        sc.close();
	}

}
