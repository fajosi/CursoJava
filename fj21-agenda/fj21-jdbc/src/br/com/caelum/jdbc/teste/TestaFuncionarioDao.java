package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;


public class TestaFuncionarioDao {

	public static void main(String args[]){
		
		//TestaInsercao();
		//TestaLista();
		//TestaBuscaPorId();
		//TestaBuscaPorNome();
		//TestaDelecao();
		
	}
	
	public static void TestaInsercao() {
	
		//pronto para gravar
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Graziela");
		funcionario.setUsuario("grazi");
		funcionario.setSenha("c@elumJ21");
		
		FuncionarioDao dao = new FuncionarioDao();
		
		dao.adiciona(funcionario);
		
		System.out.println("Gravado!");
	}

	public static void TestaLista() {
		
		FuncionarioDao dao = new FuncionarioDao();
		
		List<Funcionario> funcionarios = dao.getLista();
		
		for(Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Usuario: " + funcionario.getUsuario());
			System.out.println("Senha: " + funcionario.getSenha());
			System.out.println("Id: " + funcionario.getId());
			System.out.println("\n");

		}
	}

	public static void TestaBuscaPorId() {
		
		FuncionarioDao dao = new FuncionarioDao();
		
		Funcionario funcionario = dao.buscaPorId(1);
		
		System.out.println("**** Retorno");
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Usuario: " + funcionario.getUsuario());
		System.out.println("Senha: " + funcionario.getSenha());
		System.out.println("Id: " + funcionario.getId());
		System.out.println("\n");
		System.out.println("\n");

	}

	public static void TestaBuscaPorNome() {
		
		FuncionarioDao dao = new FuncionarioDao();
		
		Funcionario funcionario = dao.buscaPorNome("gra");
		
		System.out.println("**** Retorno");
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Usuario: " + funcionario.getUsuario());
		System.out.println("Senha: " + funcionario.getSenha());
		System.out.println("Id: " + funcionario.getId());
		System.out.println("\n");


	}
	
	public static void TestaDelecao()
	{
		FuncionarioDao dao = new FuncionarioDao();
		Funcionario funcionario = dao.buscaPorId(new Long(4));
		dao.remove(funcionario);
		
		System.out.println("Deletado!");
	}
	
}
