package comm.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import comm.example.factory.*;

import comm.example.factory.MyconnectionFactory;

public class Users implements Serializable {

	
	public static int serialVersionUID = 200;
	
	private String name ;
	private String password ;
	private String email;
	private String country;
	Connection connection=null;
	
	
	public Users() {
		super();
	}
	
	public Users(String name, String password, String email, String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}	
	
	public List<String> emailValidation() throws NamingException, SQLException {
		connection = MyconnectionFactory.getMySQLConnectionForMyDB();
		List<String> list=new ArrayList<String>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select email from users");
		while(rs.next()) {
			list.add(rs.getString(1));
		}
			
		return list;
		
	}
	
	public List<String> passwordValidation(String email) throws NamingException, SQLException {
		connection = MyconnectionFactory.getMySQLConnectionForMyDB();
		List<String> list=new ArrayList<String>();
		PreparedStatement ps = connection.prepareStatement("select password from users where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getString(1));
		}
			
		return list;
		
	}
}
