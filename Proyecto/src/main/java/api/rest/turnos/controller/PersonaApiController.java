package api.rest.turnos.controller;

import api.rest.turnos.api.PersonaApi;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaListaPersonas;
import api.rest.turnos.model.swagger.RespuestaPersona;
import api.rest.turnos.model.swagger.RespuestaPersonaRegistrada;
import api.rest.turnos.model.swagger.Turno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
@RestController
public class PersonaApiController implements PersonaApi {
    private static final Logger log = LoggerFactory.getLogger(PersonaApiController.class);

    public ResponseEntity<RespuestaPersonaRegistrada> addPerson(Persona body) {
        return new ResponseEntity<RespuestaPersonaRegistrada>(HttpStatus.NOT_IMPLEMENTED);
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

    public ResponseEntity<Respuesta> updatePerson(String dni, String clave, PersonaConClave body) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }
}