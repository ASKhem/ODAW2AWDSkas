package com.kas.kasproy.services.usuario;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.dto.UsuarioEditDto;
import com.kas.kasproy.model.user.Usuario;
import com.kas.kasproy.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImplBD implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public Usuario createUsuario(Usuario usuario){
        usuario.setFechaRegistro(LocalDate.now());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(UsuarioEditDto usuarioDto){
        Usuario usuario = usuarioRepository.findByNombre(usuarioDto.getNombre());
        if(usuario != null){
            modelMapper.map(usuarioDto, usuario);
            return usuarioRepository.save(usuario);
        }
        return null;
    }
}
