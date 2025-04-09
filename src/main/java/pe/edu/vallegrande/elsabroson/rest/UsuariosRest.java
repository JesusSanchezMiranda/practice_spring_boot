package pe.edu.vallegrande.elsabroson.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.elsabroson.model.Usuarios;
import pe.edu.vallegrande.elsabroson.service.UsuariosService;

@RestController
@RequestMapping("/v1/api/usuarios")
public class UsuariosRest {

    @Autowired
    private UsuariosService usuariosService;

    // Listar todos los usuarios
    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return usuariosService.findAll();
    }

    // Listar usuarios por estado (activo, inactivo)
    @GetMapping("/estado/{estado}")
    public List<Usuarios> listarPorEstado(@PathVariable String estado) {
        return usuariosService.findByEstado(estado.toUpperCase());
    }

    // Guardar un usuario
    @PostMapping
    public Usuarios guardarUsuarios(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id_usuarios}")
    public ResponseEntity<Usuarios> obtenerUsuarios(@PathVariable Long id_usuarios) {
        return usuariosService.findById(id_usuarios)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id_usuarios}")
    public ResponseEntity<Usuarios> actualizarUsuarios(@PathVariable Long id_usuarios, @RequestBody Usuarios usuariosActualizado) {
        Usuarios actualizado = usuariosService.update(id_usuarios, usuariosActualizado);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id_usuarios}")
    public ResponseEntity<Void> eliminarUsuarios(@PathVariable Long id_usuarios) {
        if (usuariosService.deleteById(id_usuarios)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Restaurar un usuario por ID
    @PutMapping("/restaurar/{id_usuarios}")
    public ResponseEntity<Void> restaurarUsuario(@PathVariable Long id_usuarios) {
        if (usuariosService.restoreById(id_usuarios)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
