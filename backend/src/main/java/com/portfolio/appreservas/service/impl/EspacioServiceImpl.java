package com.portfolio.appreservas.service.impl;

import com.portfolio.appreservas.model.Espacio;
import com.portfolio.appreservas.repository.EspacioRepository;
import com.portfolio.appreservas.service.EspacioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EspacioServiceImpl implements EspacioService {

    private final EspacioRepository espacioRepository;

    @Override
    public Espacio registrarEspacio(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    @Override
    public List<Espacio> listarTodos() {
        return espacioRepository.findAll();
    }

    @Override
    public Optional<Espacio> buscarPorId(Long id) {
        return espacioRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        espacioRepository.deleteById(id);
    }
}