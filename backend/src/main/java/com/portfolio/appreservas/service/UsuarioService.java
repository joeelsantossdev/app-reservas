package com.portfolio.appreservas.service;

import com.portfolio.appreservas.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
    List<Usuario> listarTodos();
}