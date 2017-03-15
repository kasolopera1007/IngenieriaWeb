//Autor: Oscar Lopera

package IMPL;

import jdk.nashorn.internal.AssertsEnabled;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import DAO.CiudadDAO;
import DTO.Ciudad;
import Exeption.ExeptionLopera;

//En esta clase se encuentran todas las pruebas realizadas sobre nuestro ejecrcio de clase

public class CiudadDAOImplTest {

	//Prueba obtener las ciudades
	@Test
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		java.util.List<Ciudad> lista = null;
		try{
			ciudadDAO = new CiudadDAOImpl();
			lista = ciudadDAO.obtener();
			assertTrue(lista.size()>0);
			
		}catch (ExeptionLopera e){
			e.printStackTrace();
			fail (e.getMessage());
		}
	}
	
	
	//Prueba obtener una ciudad por codigo
	
	public void testObtener1() {
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try{
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(1L);
			assertTrue(ciudad!=null);
			
		}catch (ExeptionLopera e){
			e.printStackTrace();
			fail (e.getMessage());
		}
	}


}
