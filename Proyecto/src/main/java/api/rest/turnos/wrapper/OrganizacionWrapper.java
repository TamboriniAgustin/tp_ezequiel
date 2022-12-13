package api.rest.turnos.wrapper;

import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.model.swagger.OrganizacionConFechaAlta;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrganizacionWrapper {
	private String fechaAlta;
	private Organizacion organizacion;
	
	public OrganizacionConFechaAlta getResponseForRequest() {
		OrganizacionConFechaAlta response = new OrganizacionConFechaAlta();
		
		response.setNombre(organizacion.getNombre());
		response.setCuit(organizacion.getCuit());
		response.setEmail(organizacion.getEmail());
		response.setDireccion(organizacion.getDireccion());
		response.setTelefono(organizacion.getTelefono());
		response.setClave(organizacion.getClave());
		response.setFechaAlta(fechaAlta);
		
		return response;
	}
}