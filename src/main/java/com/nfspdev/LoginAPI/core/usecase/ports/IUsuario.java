package com.nfspdev.loginapi.core.usecase.ports;

import com.nfspdev.loginapi.core.domain.User;

import java.util.List;

public interface IUsuario {
    User salvarUsuario(User novoUsuario);
    void deletarUsuario(String idUsuario);
    List<User> listarUsuarios();
    User buscarUsuario(String idUsuario);
    User atualizarUsuario(User novoUsuario);
}
