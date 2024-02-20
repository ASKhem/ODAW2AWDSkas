package com.kas09.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas09.bank.model.Usuario;
import com.kas09.bank.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
        @Autowired
        public UserRepository userRepository;

        public List<Usuario> getUsers() {
            return userRepository.findAll();
        }

        public Usuario createUser(Usuario usuario) {
            return userRepository.save(usuario);
        }
    
    public Usuario editUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Usuario findUserById(Long id) {
        return userRepository.findUserById(id);
    }
}
