package api.rest.turnos.exception;

import lombok.Getter;
import lombok.Setter;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-11T00:45:19.203Z[GMT]")
public class ApiException extends Exception {
	private static final long serialVersionUID = -6533916214004925912L;
	@Getter @Setter
	private int code;
    
	public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
