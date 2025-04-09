package pe.edu.vallegrande.elsabroson.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id_usuario;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "numero_documento")
    private String numero_documento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email")
    private String email;

    @Column(name = "rol")
    private String rol;

    @Column(name = "registro_actual")
    private String registro_actual;

    @Column(name = "estado")
    private String estado;

    // Getters y Setters

    public long getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getTipo_documento() {
        return tipo_documento;
    }
    
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    
    public String getNumero_documento() {
        return numero_documento;
    }
    
    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getRegistro_actual() {
        return registro_actual;
    }
    
    public void setRegistro_actual(String registro_actual) {
        this.registro_actual = registro_actual;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}