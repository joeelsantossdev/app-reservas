package com.portfolio.appreservas.controller;

import com.portfolio.appreservas.model.Reserva;
import com.portfolio.appreservas.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodas() {
        List<Reserva> reservas = reservaService.listarTodas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reserva>> buscarPorUsuarioId(@PathVariable Long usuarioId) {
        List<Reserva> reservas = reservaService.buscarPorUsuarioId(usuarioId);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }
}