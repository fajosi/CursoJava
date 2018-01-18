package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	//conexao com o banco de dados
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
	
		//SQL insert
		String sql ="insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		
		try {
			//Preparando declaracao SQL insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//definindo os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
	
			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Contato contato){
	
		//SQL insert
		String sql ="update contatos set nome = ?, email=?, endereco=?, dataNascimento=? where id = ?";
		
		try {
			//Preparando declaracao SQL insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//definindo os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			
			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Contato> getLista() {
	
		//SQL busca
		String sql ="select * from contatos";
	
		try{
			List<Contato> contatos = new ArrayList<Contato>();
		
			//Preparando declaracao SQL busca
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
			
				//Criando objeto contato
				Contato cto = new Contato();
				
				cto.setId(rs.getLong("id"));	
				cto.setNome(rs.getString("nome"));
				cto.setEmail(rs.getString("email"));
				cto.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cto.setDataNascimento(data);
				
				contatos.add(cto);
				
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
			
		}
		catch(SQLException e) 	{
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato){
	
		//SQL insert
		String sql ="delete from contatos  where id = ?";
		
		try {
			//Preparando declaracao SQL insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//definindo os valores
			stmt.setLong(1, contato.getId());
	
			stmt.execute();
			stmt.close();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public Contato buscaPorNome(String nome){
		
		//SQL busca
		String sql ="select * from contatos where nome like ?";
	
		try{
		
			//Preparando declaracao SQL busca
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			//Criando objeto contato
			Contato cto = new Contato();
			
			cto.setId(rs.getLong("id"));	
			cto.setNome(rs.getString("nome"));
			cto.setEmail(rs.getString("email"));
			cto.setEndereco(rs.getString("endereco"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			cto.setDataNascimento(data);

			
			rs.close();
			stmt.close();
			
			return cto;
			
		}
		catch(SQLException e) 	{
			throw new RuntimeException(e);
		}

		
	}
	
	public Contato buscaPorId(long id){
		//SQL busca
		String sql ="select * from contatos where id = ?";
	
		try{
		
			//Preparando declaracao SQL busca
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			//Criando objeto contato
			Contato cto = new Contato();
			
			cto.setId(rs.getLong("id"));	
			cto.setNome(rs.getString("nome"));
			cto.setEmail(rs.getString("email"));
			cto.setEndereco(rs.getString("endereco"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			cto.setDataNascimento(data);

			
			rs.close();
			stmt.close();
			
			return cto;
			
		}
		catch(SQLException e) 	{
			throw new RuntimeException(e);
		}		
	}

}
