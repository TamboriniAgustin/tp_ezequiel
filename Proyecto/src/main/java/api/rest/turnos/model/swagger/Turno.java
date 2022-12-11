package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Turno
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class Turno   {
  @JsonProperty("fecha")
  private String fecha = null;

  @JsonProperty("hora")
  private String hora = null;

  @JsonProperty("persona")
  private Persona persona = null;

  public Turno fecha(String fecha) {
    this.fecha = fecha;
    return this;
  }

  /**
   * Get fecha
   * @return fecha
   **/
  @Schema(description = "")
  
    public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public Turno hora(String hora) {
    this.hora = hora;
    return this;
  }

  /**
   * Get hora
   * @return hora
   **/
  @Schema(description = "")
  
    public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public Turno persona(Persona persona) {
    this.persona = persona;
    return this;
  }

  /**
   * Get persona
   * @return persona
   **/
  @Schema(description = "")
  
    @Valid
    public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
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
    Turno turno = (Turno) o;
    return Objects.equals(this.fecha, turno.fecha) &&
        Objects.equals(this.hora, turno.hora) &&
        Objects.equals(this.persona, turno.persona);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fecha, hora, persona);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Turno {\n");
    
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    hora: ").append(toIndentedString(hora)).append("\n");
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
