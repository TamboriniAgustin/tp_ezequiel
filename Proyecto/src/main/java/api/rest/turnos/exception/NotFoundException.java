package api.rest.turnos.exception;

import lombok.Getter;
import lombok.Setter;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
public class NotFoundException extends ApiException {
	private static final long serialVersionUID = 3554290932255448282L;
	@Getter @Setter
	private int code;
	
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
