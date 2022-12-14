package api.rest.turnos.controller;

import api.rest.turnos.api.EventoApi;
import api.rest.turnos.model.swagger.Evento;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaTurnos;
import api.rest.turnos.service.EventoService;
import api.rest.turnos.validator.EventoValidator;
import api.rest.turnos.validator.OrganizacionValidator;
import api.rest.turnos.wrapper.TurnoWrapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
@RestController
public class EventoApiController implements EventoApi {
    private static final Logger log = LoggerFactory.getLogger(EventoApiController.class);
    @Autowired
    private OrganizacionValidator validatorOrganizacion;
    @Autowired
    private EventoValidator validatorEvento;
    @Autowired
    private EventoService serviceEvento;

    /*
     * POST /evento: 
     * agrega un nuevo evento al sistema
    */
    public ResponseEntity<Respuesta> addEvent(String cuit, String clave, Evento body) {
    	log.info("[Agregar evento] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateOrganizationData(cuit, clave);
    	validatorEvento.validateEventData(body);
    	log.info("[Agregar evento] Información para el evento {} de la organización {} validada correctamente", body.getNombre(), cuit);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	serviceEvento.addEvent(cuit, clave, body);
    	log.info("[Agregar evento] El evento {} de la organización {} se agregó correctamente", body.getNombre(), cuit);
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("El evento se agregó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
    
    /*
     * DELETE /evento: 
     * elimina un evento del sistema 
    */
    public ResponseEntity<Respuesta> deleteEvent(String nombreEvento, String cuit, String clave) {
    	log.info("[Eliminar evento] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateOrganizationData(cuit, clave);
    	validatorEvento.validateEventName(nombreEvento);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	serviceEvento.deleteEvent(cuit, clave, nombreEvento);
    	log.info("[Eliminar evento] Se eliminó el evento {} de la organización {} correctamente", nombreEvento, cuit);
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("El evento fue eliminado correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
    
    /*
     * GET /evento/{cuit}/turnos: 
     * muestra los turnos de los eventos de la organización
    */
    public ResponseEntity<RespuestaTurnos> getTurns(String cuit, String nombreEvento, Boolean activo) {
    	log.info("[Obtener turnos] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorEvento.validateEventData(cuit, nombreEvento);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	List<TurnoWrapper> turnWrappers = serviceEvento.getEventTurns(cuit, nombreEvento);
    	log.info("[Obtener turnos] Se listaron {} turnos para el evento {} correctamente", turnWrappers.size(), nombreEvento);
    	
    	RespuestaTurnos response = new RespuestaTurnos();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("Se listaron los turnos correctamente");
    	
    	//Si la organización desea, filtra únicamente por turnos activos
    	if(activo != null && activo.booleanValue()) {
    		response.setTurnos(turnWrappers.stream().filter(wrapper -> wrapper.isActivo()).map(wrapper -> wrapper.getTurno()).collect(Collectors.toList()));
    	} else {
    		response.setTurnos(turnWrappers.stream().map(wrapper -> wrapper.getTurno()).collect(Collectors.toList()));
    	}
    	
    	return new ResponseEntity<RespuestaTurnos>(response, HttpStatus.OK);
    }
    
    /*
     * PATCH /evento: 
     * modifica un evento del sistema 
    */
    public ResponseEntity<Respuesta> updateEvent(String nombreEvento, String cuit, String clave, Evento body) {
    	log.info("[Modificar evento] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateOrganizationData(cuit, clave);
    	validatorEvento.validateEventName(nombreEvento);
    	validatorEvento.validateEventData(body);
    	log.info("[Modificar evento] Información para la modificación del evento {} de la organización {} validada correctamente", nombreEvento, cuit);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	serviceEvento.updateEvent(nombreEvento, cuit, clave, body);
    	log.info("[Modificar evento] El evento {} de la organización {} se modificó correctamente", body.getNombre(), cuit);
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("El evento se modificó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
}