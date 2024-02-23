package com.kas09.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import com.kas09.bank.model.Usuario;

import com.kas09.bank.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    // añadido para encriptar la contraseña
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> getUsers() {
        return userRepository.findAll();
    }

    // public Usuario createUser(Usuario usuario) {
    // if (userRepository.findUserByNombre(usuario.getNombre()) != null)
    // return null; //ya existe ese nombre de usuario
    // String passCrypted = passwordEncoder.encode(usuario.getPassword());
    // usuario.setPassword(passCrypted);
    // return userRepository.save(usuario);
    // }

    // Esta version de createUser() es más segura que la anterior,
    // ya que si el nombre de usuario ya existe, no se añadirá a la base de datos
    public Usuario createUser(Usuario usuario) {
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        try {
            return userRepository.save(usuario);
            // En caso de que el nombre de usuario ya exista lanzará una excepción
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario editUser(Usuario usuario) {
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        try {
            return userRepository.save(usuario);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Usuario findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return "Anónimo";
    }

    public String getCurrentUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getAuthorities().toString();
        }
        return "ROL_ANONYMOUS";
    }

    public boolean isAdmin() {
        return getCurrentUserRole().equals("[ROLE_ADMIN]");
    }

}