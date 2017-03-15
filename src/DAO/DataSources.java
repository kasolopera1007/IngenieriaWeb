//Autor: Oscar Lopera

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exeption.ExeptionLopera;

public class DataSources {

//Creo un elemento de conexion a base de dato utilizando el patron Singleton con el fin de que solo se tenga1 instancia de conexion a la BD
	
	private static DataSources datasource;
	
	private static Connection Connection() throws ExeptionLopera{
		Connection con = null;

			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lopera","root","");
			
			}catch (ClassNotFoundException e){
			
				throw new ExeptionLopera("Driver no encontrado Hermano. Paila",e);
				
				//Muestra de exceociones en caso de que se presente un problema de conexion con la BD.
				
			}catch (SQLException e) {
				throw new ExeptionLopera("NO establecio conexion con esa vaina",e);// TODO: handle exception
			}
			return con;
	}
	
	public static Connection getConnection() throws ExeptionLopera {
		return datasource.Connection();  //Retorna la conexion con la BD
	}
}
