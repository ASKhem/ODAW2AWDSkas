package com.kas.kasproy.services.usuario;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.dto.UsuarioEditDto;
import com.kas.kasproy.dto.UsuarioNewDto;
import com.kas.kasproy.dto.UsuarioNewStandardDto;
import com.kas.kasproy.model.user.Rol;
import com.kas.kasproy.model.user.Usuario;
import com.kas.kasproy.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImplBD implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public Usuario createEstandardUsuario(UsuarioNewStandardDto usuarioDto){
        Usuario usuario = createUsuario(usuarioDto, Rol.COSTUMER);
        return usuarioRepository.save(usuario);
    }
    
    public Usuario createUsuario(UsuarioNewDto usuarioDto){
        Usuario usuario = createUsuario(usuarioDto, null);
        return usuarioRepository.save(usuario);
    }
    
    private Usuario createUsuario(Object usuarioDto, Rol rol){
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setFechaRegistro(LocalDate.now());
        String [] fotos = {"/img/public/user/predeterminedProfilePic/demo1.png", "/img/public/user/predeterminedProfilePic/demo2.png", "/img/public/user/predeterminedProfilePic/demo3.png"};
        usuario.setFoto(fotos[(int)(Math.random()*3)]);
        if (rol != null) {
            usuario.setRol(rol);
        }
        return usuario;
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
        Usuario usuario = usuarioRepository.findById(usuarioDto.getId()).orElse(null);
        if(usuario != null) {
            Usuario userWithSameName = usuarioRepository.findByNombre(usuarioDto.getNombre());
            if(userWithSameName != null && !userWithSameName.getId().equals(usuarioDto.getId())) {
                return null;
            }
    
            Usuario userWithSameEmail = usuarioRepository.findByEmail(usuarioDto.getEmail());
            if(userWithSameEmail != null && !userWithSameEmail.getId().equals(usuarioDto.getId())) {
                return null;
            }
    
            modelMapper.map(usuarioDto, usuario);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    // public UsuarioEditDto toEditDto(Usuario usuario){
    //     return modelMapper.map(usuario, UsuarioEditDto.class);
    // }

}
