package api.rest.turnos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import api.rest.turnos.model.swagger.Evento;
import api.rest.turnos.model.swagger.Evento.TipoEnum;
import api.rest.turnos.wrapper.EventoWrapper;

public class WrapperEventoMapperDB implements RowMapper<EventoWrapper> {
	@Override
	public EventoWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventoWrapper model = new EventoWrapper();
		model.setActivo(rs.getBoolean("activo"));
		model.setFecha_creacion(rs.getString("fecha_creacion"));
		
		Evento evento = new Evento();
		evento.setNombre(rs.getString("nombre"));
		evento.setUbicacion(rs.getString("ubicacion"));
		evento.setTipo(TipoEnum.fromValue(rs.getString("tipo")));
		evento.setFecha(rs.getString("fecha_realizacion"));
		model.setEvento(evento);
		
		return model;
	}
}