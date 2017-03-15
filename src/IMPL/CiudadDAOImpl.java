//Autor: Oscar Lopera

package IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CiudadDAO;
import DAO.DataSources;
import DTO.Ciudad;
import Exeption.ExeptionLopera;

// Clase para el DAO
public class CiudadDAOImpl implements CiudadDAO{

	//Metodos de implementacion del DAO
	@Override
	public List<Ciudad> obtener() throws ExeptionLopera {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		
		try{
			con = DataSources.getConnection();
			ps =con.prepareStatement("Select * From Ciudades");
			rs = ps.executeQuery();
			while (rs.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
			 }
			
			//Captura de errores y cierre de todos los recursos utilizados
			}catch (SQLException e) {
				throw new ExeptionLopera("Error Consultante",e);
			}finally {
				try{
					if(rs!=null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(con!=null){
						con.close();
					}
			}catch (SQLException e) {
				throw new ExeptionLopera("Error cerrando",e);
			}
		}
		return lista;
	}
	public Ciudad obtener(Long codigo) throws ExeptionLopera {
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Ciudad ciudad = null;
		
		try{
			con = DataSources.getConnection();
			ps = con.prepareStatement("select * from ciudades where codigo = ?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if (rs.next()){
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
			
		}catch(SQLException e){
			throw new ExeptionLopera("Error consultando", e);
			
		}finally{
			try{
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			}catch(SQLException e){
				throw new ExeptionLopera("Error cerrando", e);
			}
		}
		
		return ciudad;
	}
}
