package com.portfolio.appreservas.controller;

import com.portfolio.appreservas.model.Espacio;
import com.portfolio.appreservas.service.EspacioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class EspacioController {

    private final EspacioService espacioService;

    @PostMapping
    public ResponseEntity<Espacio> registrarEspacio(@RequestBody Espacio espacio) {
        Espacio nuevoEspacio = espacioService.registrarEspacio(espacio);
        return new ResponseEntity<>(nuevoEspacio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Espacio>> listarTodos() {
        List<Espacio> espacios = espacioService.listarTodos();
        return new ResponseEntity<>(espacios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espacio> buscarPorId(@PathVariable Long id) {
        return espacioService.buscarPorId(id)
                .map(espacio -> new ResponseEntity<>(espacio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        if (espacioService.buscarPorId(id).isPresent()) {
            espacioService.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}