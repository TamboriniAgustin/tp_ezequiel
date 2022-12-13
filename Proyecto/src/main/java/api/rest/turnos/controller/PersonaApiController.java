package api.rest.turnos.controller;

import api.rest.turnos.api.PersonaApi;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaListaPersonas;
import api.rest.turnos.model.swagger.RespuestaPersona;
import api.rest.turnos.model.swagger.RespuestaPersonaRegistrada;
import api.rest.turnos.model.swagger.Turno;
import api.rest.turnos.service.PersonaService;
import api.rest.turnos.validator.PersonaValidator;

import java.math.BigDecimal;

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
    private PersonaService servicePersona;
    
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

    public ResponseEntity<Respuesta> addTurn(String cuit, String evento, Turno body) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Respuesta> deletePerson(String dni, String clave) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RespuestaPersona> getPerson(String dni) {
        return new ResponseEntity<RespuestaPersona>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RespuestaListaPersonas> getPersons(String apellido) {
        return new ResponseEntity<RespuestaListaPersonas>(HttpStatus.NOT_IMPLEMENTED);
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