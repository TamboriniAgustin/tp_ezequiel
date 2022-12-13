package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * RespuestaListaOrganizaciones
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-13T03:59:09.308Z[GMT]")


public class RespuestaListaOrganizaciones extends Respuesta  {
  @JsonProperty("organizaciones")
  @Valid
  private List<OrganizacionConFechaAlta> organizaciones = null;

  public RespuestaListaOrganizaciones organizaciones(List<OrganizacionConFechaAlta> organizaciones) {
    this.organizaciones = organizaciones;
    return this;
  }

  public RespuestaListaOrganizaciones addOrganizacionesItem(OrganizacionConFechaAlta organizacionesItem) {
    if (this.organizaciones == null) {
      this.organizaciones = new ArrayList<OrganizacionConFechaAlta>();
    }
    this.organizaciones.add(organizacionesItem);
    return this;
  }

  /**
   * Get organizaciones
   * @return organizaciones
   **/
  @Schema(description = "")
      @Valid
    public List<OrganizacionConFechaAlta> getOrganizaciones() {
    return organizaciones;
  }

  public void setOrganizaciones(List<OrganizacionConFechaAlta> organizaciones) {
    this.organizaciones = organizaciones;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaListaOrganizaciones respuestaListaOrganizaciones = (RespuestaListaOrganizaciones) o;
    return Objects.equals(this.organizaciones, respuestaListaOrganizaciones.organizaciones) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizaciones, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaListaOrganizaciones {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    organizaciones: ").append(toIndentedString(organizaciones)).append("\n");
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
