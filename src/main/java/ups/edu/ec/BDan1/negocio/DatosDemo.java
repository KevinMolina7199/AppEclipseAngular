package ups.edu.ec.BDan1.negocio;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.BDan1.datos.personaDao;
import ups.edu.ec.BDan1.modelo.Persona;

@Singleton
@Startup
public class DatosDemo {
	@Inject
	private personaDao daoPersona;
	
	
	@PostConstruct
	public void init() {
		
		Persona per1 = new Persona();
		per1.setId("1");
		per1.setCedula("0105322291");
		per1.setNombre("Danny Peralta");
		per1.setAltura(1.7);
		daoPersona.insert(per1);
		
		Persona per2 = new Persona();
		per2.setId("2");
		per2.setCedula("0105987414");
		per2.setNombre("Jorge Sayago");
		per2.setAltura(1.6);
		daoPersona.insert(per2);
		
		List<Persona> persona = daoPersona.getAll();
		for(Persona per: persona) {
			System.out.println(per);
		}
		
	}
}
