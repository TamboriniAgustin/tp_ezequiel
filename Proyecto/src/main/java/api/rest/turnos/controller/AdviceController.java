package api.rest.turnos.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import api.rest.turnos.exception.EntradaInvalidaException;
import api.rest.turnos.model.swagger.Respuesta;

@ControllerAdvice
public class AdviceController {
	private Respuesta response = new Respuesta();
	private static final Logger log = LoggerFactory.getLogger(AdviceController.class);
	
	@ExceptionHandler(EntradaInvalidaException.class)
	public ResponseEntity<Respuesta> entradaInvalidaException(EntradaInvalidaException e) {
		log.error("Alguna de las entradas ingresadas es invalida", e);
		response.setStatus(new BigDecimal(405));
		response.setDescripcion(e.getMessage());
		return new ResponseEntity<Respuesta>(response, HttpStatus.valueOf(405));
	}
}