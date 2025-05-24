package pe.edu.vallegrande.elsabroson.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer users_id;

    @Column(name = "document_type")
    private String document_type;

    @Column(name = "document_number")
    private String document_number;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @CreationTimestamp
    @Column(name = "registration_date", updatable = false)
    private LocalDate registration_date;

    @Column(name = "state")
    private String state = "A";

}
