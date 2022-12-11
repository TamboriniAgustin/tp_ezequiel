package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * RespuestaPersona
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class RespuestaPersona extends Respuesta  {
  @JsonProperty("persona")
  private PersonaConClave persona = null;

  public RespuestaPersona persona(PersonaConClave persona) {
    this.persona = persona;
    return this;
  }

  /**
   * Get persona
   * @return persona
   **/
  @Schema(description = "")
  
    @Valid
    public PersonaConClave getPersona() {
    return persona;
  }

  public void setPersona(PersonaConClave persona) {
    this.persona = persona;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaPersona respuestaPersona = (RespuestaPersona) o;
    return Objects.equals(this.persona, respuestaPersona.persona) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaPersona {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
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
