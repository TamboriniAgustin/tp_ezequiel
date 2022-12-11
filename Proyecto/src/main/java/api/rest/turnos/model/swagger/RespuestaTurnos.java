package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * RespuestaTurnos
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class RespuestaTurnos extends Respuesta  {
  @JsonProperty("turnos")
  @Valid
  private List<Turno> turnos = null;

  public RespuestaTurnos turnos(List<Turno> turnos) {
    this.turnos = turnos;
    return this;
  }

  public RespuestaTurnos addTurnosItem(Turno turnosItem) {
    if (this.turnos == null) {
      this.turnos = new ArrayList<Turno>();
    }
    this.turnos.add(turnosItem);
    return this;
  }

  /**
   * Get turnos
   * @return turnos
   **/
  @Schema(description = "")
      @Valid
    public List<Turno> getTurnos() {
    return turnos;
  }

  public void setTurnos(List<Turno> turnos) {
    this.turnos = turnos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaTurnos respuestaTurnos = (RespuestaTurnos) o;
    return Objects.equals(this.turnos, respuestaTurnos.turnos) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(turnos, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaTurnos {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    turnos: ").append(toIndentedString(turnos)).append("\n");
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
