package api.rest.turnos.controller;

import api.rest.turnos.api.OrganizacionApi;
import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.model.swagger.Respuesta;
import api.rest.turnos.model.swagger.RespuestaListaOrganizaciones;
import api.rest.turnos.model.swagger.RespuestaOrganizacion;
import api.rest.turnos.service.OrganizacionService;
import api.rest.turnos.validator.OrganizacionValidator;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
@RestController
public class OrganizacionApiController implements OrganizacionApi {
    private static final Logger log = LoggerFactory.getLogger(OrganizacionApiController.class);
    @Autowired
    private OrganizacionValidator validatorOrganizacion;
    @Autowired
    private OrganizacionService serviceOrganizacion;

    /*
     * POST /organizacion: 
     * agrega una nueva organización al sistema 
    */
    public ResponseEntity<Respuesta> addOrganization(Organizacion body) {
    	log.info("[Agregar organización] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateOrganizationData(body);
    	log.info("[Agregar organización] Información para la organización {}(Cuit: {}) validada correctamente", body.getNombre(), body.getCuit());
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	serviceOrganizacion.addOrganization(body);
    	log.info("[Agregar organización] Organización {}(Cuit: {}) agregada con éxito", body.getNombre(), body.getCuit());
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("La organización se agregó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
    
    /*
     * DELETE /organizacion: 
     * elimina una organización del sistema 
    */
    public ResponseEntity<Respuesta> deleteOrganization(String cuit, String clave) {
    	log.info("[Eliminar organización] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateOrganizationData(cuit, clave);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	serviceOrganizacion.deleteOrganization(cuit, clave);
    	log.info("[Eliminar organización] Organización {} eliminada con éxito", cuit);
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("La organización se eliminó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
    
    /*
     * GET /organizacion/{filtro}: 
     * trae una organización buscando por nombre o cuit 
    */
    public ResponseEntity<RespuestaOrganizacion> getOrganizationByFilter(String filtro) {
    	log.info("[Mostrar organización] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateFilterData(filtro);
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	Organizacion organization = serviceOrganizacion.getOrganizationByCuitOrName(filtro);
    	log.info("[Mostrar organización] Organización {}(Cuit: {}) eliminada con éxito", organization.getNombre(), organization.getCuit());
    	
    	RespuestaOrganizacion response = new RespuestaOrganizacion();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("Organización listada correctamente");
    	response.setOrganizacion(organization);
    	
        return new ResponseEntity<RespuestaOrganizacion>(response, HttpStatus.OK);
    }
    
    /*
     * GET /organizacion: 
     * trae todas las organizaciones
    */
    public ResponseEntity<RespuestaListaOrganizaciones> getOrganizations() {
    	log.info("[Mostrar organizaciones] Se recibió una solicitud");
    	
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	List<Organizacion> organizations = serviceOrganizacion.getOrganizations();
    	log.info("[Mostrar organizaciones] {} organizaciones obtenidas con éxito", organizations.size());
    	
    	RespuestaListaOrganizaciones response = new RespuestaListaOrganizaciones();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("Organizaciones listadas correctamente");
    	response.setOrganizaciones(organizations);
    	
        return new ResponseEntity<RespuestaListaOrganizaciones>(response, HttpStatus.OK);
    }

    /*
     * PUT /organizacion: 
     * actualiza la información de una organización del sistema 
    */
    public ResponseEntity<Respuesta> updateOrganization(String cuit, String clave, Organizacion body) {
    	log.info("[Actualizar organización] Se recibió una solicitud");
    	
    	//Se validan los datos de entrada
    	validatorOrganizacion.validateOrganizationData(cuit, clave);
    	validatorOrganizacion.validateOrganizationData(body);
    	log.info("[Actualizar organización] Información para la actualización de la organización {}(Cuit: {}) validada correctamente", body.getNombre(), body.getCuit());
    	//Se ejecuta la lógica de negocio correspondiente a la petición
    	serviceOrganizacion.updateOrganization(cuit, clave, body);
    	log.info("[Actualizar organización] Organización {}(Cuit: {}) actualizada con éxito", body.getNombre(), body.getCuit());
    	
    	Respuesta response = new Respuesta();
    	response.setStatus(new BigDecimal(200));
    	response.setDescripcion("La organización se actualizó correctamente");
    	
        return new ResponseEntity<Respuesta>(response, HttpStatus.OK);
    }
}