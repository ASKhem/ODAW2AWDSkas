package com.kas09.bank.service;

import java.util.List;

import com.kas09.bank.model.Usuario;

public interface UserService {
    public List<Usuario> getUsers();
    public Usuario createUser(Usuario user);
    public Usuario editUser(Usuario user);
    public void deleteUser(Long id);
    public Usuario findUserById(Long id);
}
