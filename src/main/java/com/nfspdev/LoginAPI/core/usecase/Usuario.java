package com.nfspdev.loginAPI.core.usecase;

import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import com.nfspdev.loginAPI.adapters.dto.mapper.IAdapterMapper;
import com.nfspdev.loginAPI.core.domain.User;
import com.nfspdev.loginAPI.core.usecase.ports.IUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        Optional<UserEntity> entidadeRecuperada = service.findUserById(idUsuario);
        if (entidadeRecuperada.isPresent()) {
            UserEntity usuarioRecuperado = entidadeRecuperada.get();
            return adapterMapper.toDomain(usuarioRecuperado);
        }
        return null;
    }

    @Override
    public User atualizarUsuario(User novoUsuario) {
        Optional<UserEntity> entidadeRecuperada = service.findUserById(novoUsuario.getId());
        if (entidadeRecuperada.isPresent()) {
            UserEntity usuarioRecuperado = entidadeRecuperada.get();
            User usuarioRecuperadoConvertido = adapterMapper.toDomain(usuarioRecuperado);
            User usuarioAtualizadao = atualizarDadosUsuario(usuarioRecuperadoConvertido, novoUsuario);
            return adapterMapper.toDomain(service.updateUser(adapterMapper.toEntity(usuarioAtualizadao)));
        }
        return null;
    }

    private static User atualizarDadosUsuario(User usuarioRecuperado, User novoUsuario){
        usuarioRecuperado.setName(novoUsuario.getName());
        usuarioRecuperado.setLogin(novoUsuario.getLogin());
        usuarioRecuperado.setPassword(novoUsuario.getPassword());
        return usuarioRecuperado;
    }
}
