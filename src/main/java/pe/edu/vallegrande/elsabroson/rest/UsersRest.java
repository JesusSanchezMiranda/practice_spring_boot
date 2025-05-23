package pe.edu.vallegrande.elsabroson.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.edu.vallegrande.elsabroson.model.Users;
import pe.edu.vallegrande.elsabroson.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/users")
public class UsersRest {

    private final UsersService usersService;

    public UsersRest(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/estado/{state}")
    public List<Users> findByState(@PathVariable String state) {
        boolean internalState;
        if ("A".equalsIgnoreCase(state)) {
            internalState = true;
        } else if ("I".equalsIgnoreCase(state)) {
            internalState = false;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El estado debe ser 'A' o 'I'");
        }

        return usersService.findByState(internalState);
    }

    @GetMapping("/{users_id}")
    public Optional<Users> findById(@PathVariable Integer users_id) {
        return usersService.findById(users_id);
    }

    @PostMapping("/save")
    public Users save(@RequestBody Users users) {
        return usersService.save(users);
    }

    @PutMapping("/update/{users_id}")
    public Users update(@PathVariable("users_id") Integer users_id, @RequestBody Users users) {
        users.setUsers_id(users_id);
        return usersService.update(users);
    }

    @DeleteMapping("/delete/{users_id}")
    public void delete(@PathVariable Integer users_id) {
        usersService.delete(users_id);
    }

    @PutMapping("/restore/{users_id}")
    public void restore(@PathVariable Integer users_id) {
        usersService.restore(users_id);
    }

}
