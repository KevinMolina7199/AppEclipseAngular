package ups.edu.ec.BDan1.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.BDan1.datos.personaDao;
import ups.edu.ec.BDan1.modelo.Persona;

@Stateless
public class GestionPersona {

	@Inject
	private personaDao daopersona;
	
	public void guardarPersona(Persona persona) throws Exception {
		//if(!this.isCedulaValida(persona.getCedula()))
			//throw new Exception("Id incorrecta");
		
		if(daopersona.readString(persona.getCedula()) == null) {
			try {
				daopersona.insert(persona);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daopersona.update(persona);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length() >= 10;
	}
	
	public void guardarClientes(String cedula, String nombre, String direccion) {
		
	}
	
	public void eliminarCliente(Persona persona) throws Exception {
		/*
	    if (!this.isCedulaValida(persona.getCedula())) {
	        throw new Exception("Cedula incorrecta");
	    }

	    Persona persona1 = daopersona.read(persona.getCedula());
	    if (persona1 == null) {
	        throw new Exception("El cliente con la cedula " + persona.getCedula() + " no existe");
	    }
*/
	    try {
	    	daopersona.deleteString(persona);
	    } catch (Exception e) {
	        throw new Exception("Error al eliminar: " + e.getMessage());
	    }
	}

	public void actualizarCliente(Persona persona) throws Exception {
		/*
	    if (!isCedulaValida(persona.getCedula())) {
	        throw new Exception("Cédula incorrecta");
	    }

	    Persona personaExistente = daopersona.read(persona.getCedula());
	    if (personaExistente == null) {
	        throw new Exception("El cliente con la cédula " + persona.getCedula() + " no existe");
	    }
*/
	    try {
	    	daopersona.update(persona); 
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}
	
	public List<Persona> listarBienes(){
		return daopersona.getAll();
	}
}
