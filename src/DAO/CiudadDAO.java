//Autor: Oscar Lopera
package DAO;

import java.util.List;
import DTO.Ciudad;
import Exeption.ExeptionLopera;

//Interfas definida por los usuarios
public interface CiudadDAO{

	//Entrega la lista completa en la BD ordenada por su nombre
	public List<Ciudad> obtener() throws ExeptionLopera;
	
	public Ciudad obtener(Long codigo) throws ExeptionLopera;
	
}
