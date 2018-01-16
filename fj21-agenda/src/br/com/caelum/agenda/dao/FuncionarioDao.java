package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.modelo.Funcionario;

public class FuncionarioDao {
	
	//conexao com o banco de dados
	private Connection connection;

	//Construtor
	public FuncionarioDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Funcionario funcionario){
	
		//SQL insert
		String sql ="insert into funcionarios (nome, usuario, senha) values (?,?,?)";
		
		try {
			//Preparando declaracao SQL insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//definindo os valores
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
	
			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Funcionario funcionario){
	
		//SQL insert
		String sql ="update funcionarios set nome = ?, usuario=?, senha=? where id = ?";
		
		try {
			//Preparando declaracao SQL insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//definindo os valores
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			
			
			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Funcionario> getLista() {
	
		//SQL busca
		String sql ="select * from funcionarios";
	
		try{
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
			//Preparando declaracao SQL busca
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
			
				//Criando objeto contato
				Funcionario func = new Funcionario();
				
				func.setId(rs.getLong("id"));	
				func.setNome(rs.getString("nome"));
				func.setUsuario(rs.getString("usuario"));
				func.setSenha(rs.getString("senha"));
							
				funcionarios.add(func);
			}
			
			rs.close();
			stmt.close();
			
			return funcionarios;
			
		}
		catch(SQLException e) 	{
			throw new RuntimeException(e);
		}
	}

	public void remove(Funcionario funcionario){
	
		//SQL insert
		String sql ="delete from funcionarios  where id = ?";
		
		try {
			//Preparando declaracao SQL insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//definindo os valores
			stmt.setLong(1, funcionario.getId());
	
			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public Funcionario buscaPorNome(String nome){
		
		//SQL busca
		String sql ="select * from funcionarios where nome like ?";
	
		try{
		
			//Preparando declaracao SQL busca
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			//Criando objeto contato
			Funcionario func = new Funcionario();
			
			func.setId(rs.getLong("id"));	
			func.setNome(rs.getString("nome"));
			func.setUsuario(rs.getString("usuario"));
			func.setSenha(rs.getString("senha"));

			
			rs.close();
			stmt.close();
			
			return func;
			
		}
		catch(SQLException e) 	{
			throw new RuntimeException(e);
		}

		
	}
	
	public Funcionario buscaPorId(long id){
		//SQL busca
		String sql ="select * from funcionarios where id = ?";
	
		try{
		
			//Preparando declaracao SQL busca
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			//Criando objeto contato
			Funcionario func = new Funcionario();
			
			func.setId(rs.getLong("id"));	
			func.setNome(rs.getString("nome"));
			func.setUsuario(rs.getString("usuario"));
			func.setSenha(rs.getString("senha"));

			
			rs.close();
			stmt.close();
			
			return func;
			
		}
		catch(SQLException e) 	{
			throw new RuntimeException(e);
		}		
	}


}
