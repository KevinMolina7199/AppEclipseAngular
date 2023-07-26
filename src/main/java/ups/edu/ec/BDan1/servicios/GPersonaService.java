package ups.edu.ec.BDan1.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.BDan1.modelo.Persona;
import ups.edu.ec.BDan1.negocio.GestionPersona;

@Path("clientes")
public class GPersonaService {
	@Inject
	private GestionPersona gPersona;
	
	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Persona misDatos() {
		Persona bi1 = new Persona();
		bi1.setId("3");
		bi1.setCedula("0105322291");
		bi1.setNombre("Danny Peralta");
		bi1.setAltura(1.80);
		return bi1;
	}
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarBienes(Persona persona) {
		try {
			gPersona.guardarPersona(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("clientesListar")
	@Produces("application/json")
	public List<Persona> listarClientes() {	
		return gPersona.listarBienes();
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminarCliente(Persona persona) {
	    try {
	    	gPersona.eliminarCliente(persona);
	        return Response.status(Response.Status.OK).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al eliminar: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	    }
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizarCliente(Persona persona) {
	    try {
	    	gPersona.actualizarCliente(persona);
	        return Response.status(Response.Status.OK).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al actualizar: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	    }
	}
	
	
}
