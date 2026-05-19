package com.portfolio.appreservas.service;

import com.portfolio.appreservas.model.Reserva;
import java.util.List;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> listarTodas();
    List<Reserva> buscarPorUsuarioId(Long usuarioId);
}