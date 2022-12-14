package api.rest.turnos.controller;

import api.rest.turnos.api.PersonaApi;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaListaPersonas;
import api.rest.turnos.model.swagger.RespuestaPersona;
import api.rest.turnos.model.swagger.RespuestaPersonaRegistrada;
import api.rest.turnos.model.swagger.Turno;
import api.rest.turnos.service.EventoService;
import api.rest.turnos.service.PersonaService;
import api.rest.turnos.validator.EventoValidator;
import api.rest.turnos.validator.PersonaValidator;
import api.rest.turnos.validator.TurnoValidator;
import api.rest.turnos.wrapper.EventoWrapper;
import api.rest.turnos.wrapper.PersonaWrapper;

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
public class PersonaApiController implements PersonaApi {
    private static final Logger log = LoggerFactory.getLogger(PersonaApiController.class);
    @Autowired
    private PersonaValidator validatorPersona;
    @Autowired
    private EventoValidator validatorEvento;
    @Autowired
    private TurnoValidator validatorTurno;
    @Autowired
    private PersonaService servicePersona;
    @Autowired
    private EventoService serviceEvento;
    
    /*
     * POST /persona: 
     * agrega una nueva persona al sistema 
    */
    public ResponseEntity<RespuestaPersonaRegistrada> addPerson(Persona body) {
    	log.info("[Agregar persona] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorPersona.validatePersonData(body);
    	log.info("[Agregar persona] Información de {}(DNI: {}) validada correctamente", body.getNombre(), body.getDni());
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	String claveGenerada = servicePersona.addPerson(body);
    	log.info("[Agregar persona] Se agregó a {}(DNI: {}) con éxito", body.getNombre(), body.getDni());
    	
    	RespuestaPersonaRegistrada response = new RespuestaPersonaRegistrada();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("La persona se agregó correctamente");
    	response.setClave(claveGenerada);
    	
        return new ResponseEntity<RespuestaPersonaRegistrada>(response, HttpStatus.OK);
    }
    
    /*
     * GET /persona/turno: 
     * saca un turno a la persona para un evento
    */
    public ResponseEntity<Respuesta> addTurn(String cuit, String evento, Turno body) {
    	log.info("[Sacar turno] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorEvento.validateEventData(cuit, evento);
    	validatorTurno.validateTurnData(body);
    	validatorPersona.validatePersonData(body.getPersona());
    	log.info("[Sacar turno] Información del turno de {} validada correctamente", body.getPersona().getDni());
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	EventoWrapper eventWrapper = serviceEvento.getEvent(cuit, evento);
    	servicePersona.addTurn(cuit, evento, body, eventWrapper);
    	log.info("[Sacar turno] Se generó el turno al usuario {} con éxito", body.getPersona().getDni());
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("El turno se agregó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
    
    /*
     * DELETE /persona: 
     * baja la cuenta de una persona
    */
    public ResponseEntity<Respuesta> deletePerson(String dni, String clave) {
    	log.info("[Eliminar persona] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorPersona.validatePersonData(dni, clave);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	servicePersona.deletePerson(dni, clave);
    	log.info("[Eliminar persona] Se desactivó la cuenta {} con éxito", dni);
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("La persona se desactivó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
    
    /*
     * GET /persona/{dni}: 
     * trae un usuario específico
    */
    public ResponseEntity<RespuestaPersona> getPerson(String dni) {
    	log.info("[Obtener persona] Se recibió una solicitud");
    	
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	PersonaWrapper person = servicePersona.getPerson(dni);
    	log.info("[Obtener persona] Se listó la persona {} con éxito", person.getPersona().getDni());
    	
    	RespuestaPersona response = new RespuestaPersona();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("Se listó la persona correctamente");
    	response.setPersona(person.getPersona());
    	
        return new ResponseEntity<RespuestaPersona>(response, HttpStatus.OK);
    }
    
    /*
     * GET /persona: 
     * trae todos los usuarios, con la posibilidad de filtrar por apellido
    */
    public ResponseEntity<RespuestaListaPersonas> getPersons(String apellido) {
    	log.info("[Obtener personas] Se recibió una solicitud");
    	
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	List<PersonaWrapper> persons = servicePersona.getPersons(apellido);
    	log.info("[Obtener personas] Se listaron {} personas con éxito", persons.size());
    	
    	RespuestaListaPersonas response = new RespuestaListaPersonas();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("Se listaron las personas activas correctamente");
    	response.setPersonas(persons.stream().map(wrapper -> wrapper.getPersona()).collect(Collectors.toList()));
    	
        return new ResponseEntity<RespuestaListaPersonas>(response, HttpStatus.OK);
    }
    
    /*
     * PUT /persona: 
     * agrega una nueva persona al sistema 
    */
    public ResponseEntity<Respuesta> updatePerson(String dni, String clave, PersonaConClave body) {
    	log.info("[Modificar persona] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorPersona.validatePersonData(dni, clave);
    	validatorPersona.validatePersonData(body);
    	log.info("[Modificar persona] Información para actualizar el usuario {} validada correctamente", dni);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	servicePersona.updatePerson(dni, clave, body);
    	log.info("[Modificar persona] Se modificó la información del usuario {} con éxito", dni);
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("La persona se modificó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
}