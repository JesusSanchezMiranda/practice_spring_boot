package pe.edu.vallegrande.elsabroson.service;

import java.util.List;
import java.util.Optional;

import pe.edu.vallegrande.elsabroson.model.Users;

public interface UsersService {

    List<Users> findAll();

    List<Users> findByState(String state); // ← corregido

    Optional<Users> findById(Long users_id);

    Users save(Users users);

    Users update(Users users);

    void delete(Long users_id);

    void restore(Long users_id);
}