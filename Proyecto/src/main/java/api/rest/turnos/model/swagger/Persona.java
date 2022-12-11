package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Persona
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class Persona   {
  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("apellido")
  private String apellido = null;

  @JsonProperty("dni")
  private BigDecimal dni = null;

  public Persona nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   **/
  @Schema(description = "")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Persona apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
   **/
  @Schema(description = "")
  
    public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Persona dni(BigDecimal dni) {
    this.dni = dni;
    return this;
  }

  /**
   * Get dni
   * @return dni
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getDni() {
    return dni;
  }

  public void setDni(BigDecimal dni) {
    this.dni = dni;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Persona persona = (Persona) o;
    return Objects.equals(this.nombre, persona.nombre) &&
        Objects.equals(this.apellido, persona.apellido) &&
        Objects.equals(this.dni, persona.dni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, apellido, dni);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Persona {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
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
