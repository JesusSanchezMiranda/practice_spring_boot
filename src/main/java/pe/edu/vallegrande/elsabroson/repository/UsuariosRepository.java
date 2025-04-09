package pe.edu.vallegrande.elsabroson.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.elsabroson.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findByEstado(String estado);
}