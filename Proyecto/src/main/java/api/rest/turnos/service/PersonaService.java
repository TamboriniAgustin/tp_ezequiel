package api.rest.turnos.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.turnos.model.swagger.Evento.TipoEnum;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.model.swagger.Turno;
import api.rest.turnos.repository.PersonaRepository;
import api.rest.turnos.repository.TurnoRepository;
import api.rest.turnos.wrapper.EventoWrapper;
import api.rest.turnos.wrapper.PersonaWrapper;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository repositoryPersona;
	@Autowired
	private TurnoRepository repositoryTurno;
	
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
	
	public void deletePerson(String dni, String clave) {
		//Se comprueban las credenciales de la persona
		repositoryPersona.selectPersonWithPassword(dni, clave);
		//Se actualiza el estado de la persona
		repositoryPersona.updatePersonStatus(dni, "0");
	}
	
	public PersonaWrapper getPerson(String dni) {
		//Se busca el usuario por DNI en la base de datos
		return repositoryPersona.selectPersonByDNI(dni);
	}
	
	public List<PersonaWrapper> getPersons(String apellido) {
		//Se buscan los usuarios activos en la base de datos
		return repositoryPersona.selectPersons(apellido);
	}
	
	public void addTurn(String organizationCuit, String eventName, Turno turn, EventoWrapper eventWrapper) {
		//Si el evento es UNICO se establece como fecha nula ya que directamente se tomará la fecha desde el evento
		if(eventWrapper.getEvento().getTipo().equals(TipoEnum.UNICO)) {
			turn.setFecha(null);
		}
		
		//Se genera el ID del turno
		String turnId = UUID.randomUUID().toString();
		//Se agrega el turno a la base de datos
		repositoryTurno.insertTurno(turnId, organizationCuit, eventName, turn);
	}
}