package pe.edu.vallegrande.elsabroson.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.elsabroson.model.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByState(String state);
}
