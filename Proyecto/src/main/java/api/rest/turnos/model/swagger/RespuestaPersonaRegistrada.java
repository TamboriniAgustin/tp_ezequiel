package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * RespuestaPersonaRegistrada
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class RespuestaPersonaRegistrada extends Respuesta  {
  @JsonProperty("clave")
  private String clave = null;

  public RespuestaPersonaRegistrada clave(String clave) {
    this.clave = clave;
    return this;
  }

  /**
   * Get clave
   * @return clave
   **/
  @Schema(description = "")
  
    public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaPersonaRegistrada respuestaPersonaRegistrada = (RespuestaPersonaRegistrada) o;
    return Objects.equals(this.clave, respuestaPersonaRegistrada.clave) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clave, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaPersonaRegistrada {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    clave: ").append(toIndentedString(clave)).append("\n");
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
