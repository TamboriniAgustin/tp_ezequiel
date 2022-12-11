package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * RespuestaListaPersonas
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class RespuestaListaPersonas extends Respuesta  {
  @JsonProperty("personas")
  @Valid
  private List<PersonaConClave> personas = null;

  public RespuestaListaPersonas personas(List<PersonaConClave> personas) {
    this.personas = personas;
    return this;
  }

  public RespuestaListaPersonas addPersonasItem(PersonaConClave personasItem) {
    if (this.personas == null) {
      this.personas = new ArrayList<PersonaConClave>();
    }
    this.personas.add(personasItem);
    return this;
  }

  /**
   * Get personas
   * @return personas
   **/
  @Schema(description = "")
      @Valid
    public List<PersonaConClave> getPersonas() {
    return personas;
  }

  public void setPersonas(List<PersonaConClave> personas) {
    this.personas = personas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaListaPersonas respuestaListaPersonas = (RespuestaListaPersonas) o;
    return Objects.equals(this.personas, respuestaListaPersonas.personas) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personas, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaListaPersonas {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    personas: ").append(toIndentedString(personas)).append("\n");
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
