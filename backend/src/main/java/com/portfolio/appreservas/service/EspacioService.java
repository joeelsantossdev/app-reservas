package com.portfolio.appreservas.service;

import com.portfolio.appreservas.model.Espacio;
import java.util.List;
import java.util.Optional;

public interface EspacioService {
    Espacio registrarEspacio(Espacio espacio);
    List<Espacio> listarTodos();
    Optional<Espacio> buscarPorId(Long id);
    void eliminarPorId(Long id);
}