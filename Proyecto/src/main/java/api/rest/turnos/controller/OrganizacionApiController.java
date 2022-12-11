package api.rest.turnos.controller;

import api.rest.turnos.api.OrganizacionApi;
import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaListaOrganizaciones;
import api.rest.turnos.model.swagger.RespuestaOrganizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
@RestController
public class OrganizacionApiController implements OrganizacionApi {
    private static final Logger log = LoggerFactory.getLogger(OrganizacionApiController.class);

    public ResponseEntity<Respuesta> addOrganization(Organizacion body) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Respuesta> deleteOrganization(String cuit, String clave) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RespuestaOrganizacion> getOrganizationByFilter(String filtro) {
        return new ResponseEntity<RespuestaOrganizacion>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RespuestaListaOrganizaciones> getOrganizations() {
        return new ResponseEntity<RespuestaListaOrganizaciones>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Respuesta> updateOrganization(String cuit, String clave, Organizacion body) {
        return new ResponseEntity<Respuesta>(HttpStatus.NOT_IMPLEMENTED);
    }
}