package api.rest.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.repository.OrganizacionRepository;

@Service
public class OrganizacionService {
	@Autowired
	private OrganizacionRepository repositoryOrganizacion;
	
	public void addOrganization(Organizacion organization) {
		//Se agrega la organización a la base de datos
		repositoryOrganizacion.insertOrganization(organization);
	}
	
	public void updateOrganization(String cuit, String clave, Organizacion organization) {
		//Se chequea la existencia de la organización
		repositoryOrganizacion.selectOrganizationWithCredentials(cuit, clave);
		//Se modifica la organización en la base de datos
		repositoryOrganizacion.updateOrganization(cuit, organization);
	}
	
	public void deleteOrganization(String cuit, String clave) {
		//Se chequea la existencia de la organización
		repositoryOrganizacion.selectOrganizationWithCredentials(cuit, clave);
		//Se elimina la organización de la base de datos
		repositoryOrganizacion.deleteOrganization(cuit);
	}
	
	public List<Organizacion> getOrganizations() {
		//Se consultan las organizaciones existentes en la base de datos
		return repositoryOrganizacion.selectOrganizations();
	}
	
	public Organizacion getOrganizationByCuitOrName(String filter) {
		//Se consulta la organización solicitada
		return repositoryOrganizacion.selectOrganizationByCuitOrName(filter);
	}
}