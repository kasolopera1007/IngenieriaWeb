//Autor: Oscar Lopera

package clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ciudades {

	public static void main(String[] args){
		
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lopera","root",""); // Conexion con la BD Lopera
		
			PreparedStatement ps = con.prepareStatement("select *from ciudades");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString("codigo")+": "+rs.getString("nombre")); //Imprime la lista de ciudades con los parametros de codigo y nombre
		}
		}catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Los 2 catch capturan las excepciones que puedas surgir en la conexion a la BD y en la muestra de las ciudades
		}
		
	}
