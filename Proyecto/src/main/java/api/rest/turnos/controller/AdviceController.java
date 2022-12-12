package api.rest.turnos.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import api.rest.turnos.exception.EntradaDuplicadaException;
import api.rest.turnos.exception.EntradaInvalidaException;
import api.rest.turnos.exception.IdentificacionErroneaException;
import api.rest.turnos.exception.ObjetoNoListadoException;
import api.rest.turnos.model.swagger.Respuesta;

@ControllerAdvice
public class AdviceController {
	private Respuesta response = new Respuesta();
	private static final Logger log = LoggerFactory.getLogger(AdviceController.class);
	
	@ExceptionHandler(EntradaInvalidaException.class)
	public ResponseEntity<Respuesta> entradaInvalidaException(EntradaInvalidaException e) {
		log.error("Alguna de las entradas ingresadas es inválida", e);
		response.setStatus(new BigDecimal(405));
		response.setDescripcion(e.getMessage());
		return new ResponseEntity<Respuesta>(response, HttpStatus.valueOf(405));
	}
	
	@ExceptionHandler(EntradaDuplicadaException.class)
	public ResponseEntity<Respuesta> entradaDuplicadaException(EntradaDuplicadaException e) {
		log.error("Se ha intentado registrar una entrada duplicada", e);
		response.setStatus(new BigDecimal(405));
		response.setDescripcion(e.getMessage());
		return new ResponseEntity<Respuesta>(response, HttpStatus.valueOf(405));
	}
	
	@ExceptionHandler(IdentificacionErroneaException.class)
	public ResponseEntity<Respuesta> identificacionErroneaException(IdentificacionErroneaException e) {
		log.error("No se ha encontrado respuesta a la solicitud", e);
		response.setStatus(new BigDecimal(405));
		response.setDescripcion(e.getMessage());
		return new ResponseEntity<Respuesta>(response, HttpStatus.valueOf(405));
	}
	
	@ExceptionHandler(ObjetoNoListadoException.class)
	public ResponseEntity<Respuesta> notFoundException(ObjetoNoListadoException e) {
		log.error("No se ha podido listar ningún elemento", e);
		response.setStatus(new BigDecimal(404));
		response.setDescripcion(e.getMessage());
		return new ResponseEntity<Respuesta>(response, HttpStatus.valueOf(404));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Respuesta> exception(Exception e) {
		log.error("Ocurrió un error inesperado", e);
		response.setStatus(new BigDecimal(500));
		response.setDescripcion("Ocurrió un error inesperado");
		return new ResponseEntity<Respuesta>(response, HttpStatus.valueOf(500));
	}
}