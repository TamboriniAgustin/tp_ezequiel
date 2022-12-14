package api.rest.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.turnos.model.swagger.Evento;
import api.rest.turnos.repository.EventoRepository;
import api.rest.turnos.repository.OrganizacionRepository;
import api.rest.turnos.repository.TurnoRepository;
import api.rest.turnos.wrapper.EventoWrapper;
import api.rest.turnos.wrapper.TurnoWrapper;

@Service
public class EventoService {
	@Autowired
	private OrganizacionRepository repositoryOrganizacion;
	@Autowired
	private EventoRepository repositoryEvento;
	@Autowired
	private TurnoRepository repositoryTurno;
	
	public void addEvent(String cuit, String clave, Evento event) {
		//Se comprueban las credenciales de la organización
		repositoryOrganizacion.selectOrganizationWithCredentials(cuit, clave);
		//Se agrega el evento a la base de datos
		repositoryEvento.insertEvent(cuit, event);
	}
	
	public void updateEvent(String eventName, String cuit, String clave, Evento event) {
		//Se comprueban las credenciales de la organización
		repositoryOrganizacion.selectOrganizationWithCredentials(cuit, clave);
		//Se chequea la existencia del evento
		repositoryEvento.selectEvento(eventName, cuit);
		//Se actualiza el evento en la base de datos
		repositoryEvento.updateEvent(eventName, cuit, event);
	}
	
	public void deleteEvent(String cuit, String clave, String eventName) {
		//Se comprueban las credenciales de la organización
		repositoryOrganizacion.selectOrganizationWithCredentials(cuit, clave);
		//Se chequea la existencia del evento
		repositoryEvento.selectEvento(eventName, cuit);
		//Se elimina el evento de la base de datos
		repositoryEvento.deleteOrganization(cuit, eventName);
	}
	
	public EventoWrapper getEvent(String cuit, String name) {
		//Se busca el evento en la base de datos
		return repositoryEvento.selectEvento(name, cuit);
	}
	
	public List<TurnoWrapper> getEventTurns(String cuit, String name) {
		//Se chequea la existencia del evento
		repositoryEvento.selectEvento(name, cuit);
		//Se buscan los turnos del evento
		return repositoryTurno.selectEventTurns(name, cuit);
	}
}