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

    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return usuariosService.findAll();
    }

    @GetMapping("/estado/{estado}")
    public List<Usuarios> listarPorEstado(@PathVariable String estado) {
        return usuariosService.findByEstado(estado.toUpperCase());
    }

    @PostMapping
    public Usuarios guardarUsuarios(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarios(@PathVariable Long id_usuario) {
        return usuariosService.findById(id_usuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuarios(@PathVariable Long id_usuario, @RequestBody Usuarios usuariosActualizado) {
        Usuarios actualizado = usuariosService.update(id_usuario, usuariosActualizado);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarios(@PathVariable Long id_usuario) {
        if (usuariosService.deleteById(id_usuario)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/restaurar/{id}")
    public ResponseEntity<Void> restaurarUsuario(@PathVariable Long id_usuario) {
        if (usuariosService.restoreById(id_usuario)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}