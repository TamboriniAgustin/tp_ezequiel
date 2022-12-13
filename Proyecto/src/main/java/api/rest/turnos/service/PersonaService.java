package api.rest.turnos.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.repository.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository repositoryPersona;
	
	public String addPerson(Persona person) {
		//Se genera la clave automática
		String clave = UUID.randomUUID().toString();
		//Se agrega la persona a la base de datos
		repositoryPersona.insertPerson(clave, person);
		
		return clave;
	}
	
	public void updatePerson(String dni, String clave, PersonaConClave person) {
		//Se comprueban las credenciales de la persona
		repositoryPersona.selectPersonWithPassword(dni, clave);
		//Se actualiza la información de la base de datos
		repositoryPersona.updatePerson(dni, person);
	}
}