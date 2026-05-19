package com.portfolio.appreservas.service.impl;

import com.portfolio.appreservas.model.Reserva;
import com.portfolio.appreservas.repository.ReservaRepository;
import com.portfolio.appreservas.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> buscarPorUsuarioId(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }
}