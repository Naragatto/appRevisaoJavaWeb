package br.csi.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import br.csi.model.usuario;
import br.csi.model.util.conectDBPostgres;

/*
create table usuario(
	id serial, login varchar(50) not null, senha varchar(50) not null,
	primary key(id)
)

select * from usuario

insert into usuario(login, senha) values ('test', '123')
*/

public class usuarioDAO {
	
	public static void main(String[] args) {
		/*usuario u = new usuario();
		u.setUsuario("test");
		u.setSenha("123");
		
		try {
			System.out.println("Autenticado: "+new usuarioDAO().autenticado(u));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public boolean inserir(usuario u) throws SQLException{
		boolean inserido = false;
		Connection c = conectDBPostgres.getConection();
		
		String sql ="insert into usuario(login, senha) values (?, ?)";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		stmtPre.setString(1, u.getUsuario());
		stmtPre.setString(2, u.getSenha());
		if(stmtPre.executeUpdate() > 0){
			inserido = true;
		}
		
		return inserido;
	}
	
	public boolean remover(int id) throws SQLException{
		boolean removido = false;
		Connection c = conectDBPostgres.getConection();
		
		String sql ="delete from usuario where id =?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		stmtPre.setInt(1, id);
		if(stmtPre.executeUpdate() > 0){
			removido = true;
		}
		
		return removido;
	}
	
	public boolean autenticado(usuario u) throws SQLException{
		boolean autenticado = false;
		
		Connection c = conectDBPostgres.getConection();
		
		String sql = "select * from usuario where "
				+ "login =? and senha =?";
		PreparedStatement stmtPre = c.prepareStatement(sql);
		stmtPre.setString(1, u.getUsuario());
		stmtPre.setString(2, u.getSenha());			
		ResultSet rs = stmtPre.executeQuery();
		
		
		
		while(rs.next()){
			//long id = rs.getLong("id");
			//String usuario = rs.getString("login");
			//String senha = rs.getString("senha");
			autenticado = true;
		}
		
		return autenticado;
		
	}
	
	public List<usuario> getUsuarios(){
		ArrayList<usuario> usuarios = new ArrayList<usuario>();
		System.out.println("dentro do getUsuarios()");
		try{
				
			PreparedStatement stmt =  conectDBPostgres.getConection().prepareStatement("select * from USUARIO");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				usuario t = new usuario();
				t.setId(rs.getLong("id"));
				t.setUsuario(rs.getString("login"));
				t.setSenha(rs.getString("senha"));
				System.out.println("usuário: "+t.getUsuario());
				usuarios.add(t);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
}
