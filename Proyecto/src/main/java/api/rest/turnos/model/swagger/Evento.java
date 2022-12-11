package api.rest.turnos.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Evento
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")


public class Evento   {
  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("ubicacion")
  private String ubicacion = null;

  @JsonProperty("fecha")
  private String fecha = null;

  /**
   * Gets or Sets tipo
   */
  public enum TipoEnum {
    UNICO("UNICO"),
    
    RECURRENTE("RECURRENTE");

    private String value;

    TipoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoEnum fromValue(String text) {
      for (TipoEnum b : TipoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("tipo")
  private TipoEnum tipo = null;

  public Evento nombre(String nombre) {
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

  public Evento ubicacion(String ubicacion) {
    this.ubicacion = ubicacion;
    return this;
  }

  /**
   * Get ubicacion
   * @return ubicacion
   **/
  @Schema(description = "")
  
    public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public Evento fecha(String fecha) {
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

  public Evento tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   **/
  @Schema(description = "")
  
    public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Evento evento = (Evento) o;
    return Objects.equals(this.nombre, evento.nombre) &&
        Objects.equals(this.ubicacion, evento.ubicacion) &&
        Objects.equals(this.fecha, evento.fecha) &&
        Objects.equals(this.tipo, evento.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, ubicacion, fecha, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Evento {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    ubicacion: ").append(toIndentedString(ubicacion)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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
