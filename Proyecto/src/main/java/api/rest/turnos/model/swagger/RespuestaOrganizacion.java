package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * RespuestaOrganizacion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-13T03:59:09.308Z[GMT]")


public class RespuestaOrganizacion extends Respuesta  {
  @JsonProperty("organizacion")
  private OrganizacionConFechaAlta organizacion = null;

  public RespuestaOrganizacion organizacion(OrganizacionConFechaAlta organizacion) {
    this.organizacion = organizacion;
    return this;
  }

  /**
   * Get organizacion
   * @return organizacion
   **/
  @Schema(description = "")
  
    @Valid
    public OrganizacionConFechaAlta getOrganizacion() {
    return organizacion;
  }

  public void setOrganizacion(OrganizacionConFechaAlta organizacion) {
    this.organizacion = organizacion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaOrganizacion respuestaOrganizacion = (RespuestaOrganizacion) o;
    return Objects.equals(this.organizacion, respuestaOrganizacion.organizacion) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizacion, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaOrganizacion {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    organizacion: ").append(toIndentedString(organizacion)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
