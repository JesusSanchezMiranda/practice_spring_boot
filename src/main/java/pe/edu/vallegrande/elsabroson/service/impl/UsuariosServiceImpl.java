package pe.edu.vallegrande.elsabroson.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.vallegrande.elsabroson.model.Usuarios;
import pe.edu.vallegrande.elsabroson.repository.UsuariosRepository;
import pe.edu.vallegrande.elsabroson.service.UsuariosService;

@Slf4j
@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> findAll() {
        log.info("Listando todos los Usuarios");
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> findById(Long id_usuario) {
        log.info("Buscando Usuarios con ID: " + id_usuario);
        return usuariosRepository.findById(id_usuario);
    }

    @Override
    public List<Usuarios> findByEstado(String estado) {
        log.info("Listando usuarios por estado: " + estado);
        return usuariosRepository.findByEstado(estado);
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        log.info("Guardando usuarios: " + usuarios.toString());
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios update(Long id_usuario, Usuarios usuariosActualizados) {
        return usuariosRepository.findById(id_usuario)
            .map(usuarios -> {
                usuarios.setTipo_documento(usuariosActualizados.getTipo_documento());
                usuarios.setNumero_documento(usuariosActualizados.getNumero_documento());
                usuarios.setNombre(usuariosActualizados.getNombre());
                usuarios.setApellido(usuariosActualizados.getApellido());
                usuarios.setCelular(usuariosActualizados.getCelular());
                usuarios.setEmail(usuariosActualizados.getEmail());
                usuarios.setRol(usuariosActualizados.getRol());
                usuarios.setEstado(usuariosActualizados.getEstado());
                log.info("Actualizando usuarios: " + usuarios.toString());
                return usuariosRepository.save(usuarios);
            })
            .orElse(null);
    }

    @Override
    public boolean deleteById(Long id_usuarios) {
        Optional<Usuarios> usuarioOpt = usuariosRepository.findById(id_usuarios);
        if (usuarioOpt.isPresent()) {
            Usuarios usuario = usuarioOpt.get();
            usuario.setEstado("ELIMINADO"); // E = Eliminado
            usuariosRepository.save(usuario);
            log.info("Usuario con ID: " + id_usuarios + " marcado como ELIMINADO");
            return true;
        }
        return false;
    }
    
    @Override
    public boolean restoreById(Long id_usuarios) {
        Optional<Usuarios> usuarioOpt = usuariosRepository.findById(id_usuarios);
        if (usuarioOpt.isPresent()) {
            Usuarios usuario = usuarioOpt.get();
            if ("E".equalsIgnoreCase(usuario.getEstado())) { // Solo si está Eliminado
                usuario.setEstado("A"); // A = Activo
                usuariosRepository.save(usuario);
                log.info("Usuario con ID: " + id_usuarios + " restaurado a ACTIVO");
                return true;
            }
        }
        return false;
    }
    }

