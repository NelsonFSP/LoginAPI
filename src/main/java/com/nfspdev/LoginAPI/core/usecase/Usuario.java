package com.nfspdev.loginapi.core.usecase;

import com.nfspdev.loginapi.adapters.IUserRepository;
import com.nfspdev.loginapi.adapters.dto.UserEntity;
import com.nfspdev.loginapi.adapters.dto.mapper.IAdapterMapper;
import com.nfspdev.loginapi.core.domain.User;
import com.nfspdev.loginapi.core.usecase.ports.IUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Usuario implements IUsuario {

    private final IUserRepository service;
    private final IAdapterMapper adapterMapper;

    @Override
    public User salvarUsuario(User novoUsuario) {
        UserEntity entidadeConvertida = adapterMapper.toEntity(novoUsuario);
        UserEntity usuarioSalvo = service.saveUser(entidadeConvertida);
        return adapterMapper.toDomain(usuarioSalvo);
    }

    @Override
    public void deletarUsuario(String idUsuario) {
        service.deleteUser(idUsuario);
    }

    @Override
    public List<User> listarUsuarios() {
        return service.findAllUsers().stream().map(adapterMapper::toDomain).toList();
    }

    @Override
    public User buscarUsuario(String idUsuario) {
        UserEntity entidadeRecuperada = service.findUserById(idUsuario);
        return adapterMapper.toDomain(entidadeRecuperada);

    }

    @Override
    public User atualizarUsuario(User novoUsuario) {
        UserEntity usuarioRecuperado = service.findUserById(novoUsuario.getId());
        User usuarioRecuperadoConvertido = adapterMapper.toDomain(usuarioRecuperado);
        User usuarioAtualizadao = atualizarDadosUsuario(usuarioRecuperadoConvertido, novoUsuario);
        return adapterMapper.toDomain(service.updateUser(adapterMapper.toEntity(usuarioAtualizadao)));

    }

    private static User atualizarDadosUsuario(User usuarioRecuperado, User novoUsuario) {
        usuarioRecuperado.setName(novoUsuario.getName());
        usuarioRecuperado.setLogin(novoUsuario.getLogin());
        usuarioRecuperado.setPassword(novoUsuario.getPassword());
        return usuarioRecuperado;
    }
}
