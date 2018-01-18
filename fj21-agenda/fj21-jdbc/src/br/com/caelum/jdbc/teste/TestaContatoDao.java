package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaContatoDao {
	
	public static void main(String args[]){
		
		//TestaInsercao();
		//TestaLista();
		//TestaBuscaPorId();
		//TestaBuscaPorNome();
		//TestaDelecao();
		
	
	}
	
	public static void TestaInsercao() {
	
		//pronto para gravar
		Contato contato = new Contato();
		
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
	}

	public static void TestaLista() {
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
		for(Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format( contato.getDataNascimento().getTime()));
			System.out.println("Id: " + contato.getId());
			System.out.println("\n");

		}
	}

	public static void TestaBuscaPorId() {
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.buscaPorId(16);
		
		System.out.println("**** Retorno");
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Endereco: " + contato.getEndereco());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format( contato.getDataNascimento().getTime()));
		System.out.println("Id: " + contato.getId());
		System.out.println("\n");

	}

	public static void TestaBuscaPorNome() {
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.buscaPorNome("gra");
		
		System.out.println("**** Retorno");
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Endereco: " + contato.getEndereco());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format( contato.getDataNascimento().getTime()));
		System.out.println("Id: " + contato.getId());
		System.out.println("\n");

	}
	
	public static void TestaDelecao()
	{
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.buscaPorId(new Long(17));
		dao.remove(contato);
		
		System.out.println("Deletado!");
	}
	
}
