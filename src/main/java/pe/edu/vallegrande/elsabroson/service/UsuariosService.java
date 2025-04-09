package pe.edu.vallegrande.elsabroson.service;

import java.util.List;
import java.util.Optional;
import pe.edu.vallegrande.elsabroson.model.Usuarios;

public interface UsuariosService {
    List<Usuarios> findAll();
    Optional<Usuarios> findById(Long id_usuario);
    List<Usuarios> findByEstado(String estado);
    Usuarios save(Usuarios usuarios);
    Usuarios update(Long id_usuario, Usuarios usuariosActualizado);
    boolean deleteById(Long id_usuario);
    boolean restoreById(Long id_usuario);
}