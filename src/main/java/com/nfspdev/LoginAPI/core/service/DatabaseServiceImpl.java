package com.nfspdev.loginAPI.core.service;

import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import com.nfspdev.loginAPI.core.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public abstract class DatabaseServiceImpl implements IUserRepository {
    @Override
    public List<UserEntity> findAllUsers() {
        return findAll();
    }

    @Override
    public Optional<UserEntity> findUserById(String id) {
        Optional<UserEntity> obj = findById(id);
        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
    }

    @Override
    public UserEntity saveUser(UserEntity obj) {
        return (obj);
    }

    @Override
    public void deleteUser(String id) {
        deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity obj) {
        Optional<UserEntity> rawEntity = findById(obj.id());
        try {
            if(rawEntity.isPresent()){
                UserEntity entidadeAtualizada = updateData(obj);
                save(entidadeAtualizada);
            }

        } catch (Exception e) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return null;
    }

    private UserEntity updateData(UserEntity obj) {
        return new UserEntity(obj.id(), obj.name(), obj.login(), obj.password());
    }
}
