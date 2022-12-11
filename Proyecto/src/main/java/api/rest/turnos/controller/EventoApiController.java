package api.rest.turnos.controller;

import api.rest.turnos.api.EventoApi;
import api.rest.turnos.model.swagger.Evento;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaTurnos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
@RestController
public class EventoApiController implements EventoApi {
    private static final Logger log = LoggerFactory.getLogger(EventoApiController.class);

    public ResponseEntity<Respuesta> addEvent(String cuit, String clave, Evento body) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Respuesta> deleteEvent(String nombreEvento, String cuit, String clave) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RespuestaTurnos> getTurns(String cuit, Boolean activo) {
        return new ResponseEntity<RespuestaTurnos>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Respuesta> updateEvent(String cuit, String clave, Evento body) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }
}