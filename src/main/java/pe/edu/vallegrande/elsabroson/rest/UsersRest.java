package pe.edu.vallegrande.elsabroson.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return usersService.findByState(state);
    }

    @GetMapping("/{users_id}")
    public Optional<Users> findById(@PathVariable Long users_id) {
        return usersService.findById(users_id);
    }

    @PostMapping("/save")
    public Users save(@RequestBody Users users) {
        return usersService.save(users);
    }

    @PutMapping("/update/{id}")
    public Users update(@PathVariable("id") Long id, @RequestBody Users users) {
        users.setUsers_id(id); 
        return usersService.update(users);
    }

    @DeleteMapping("/delete/{users_id}")
    public void delete(@PathVariable Long users_id) {
        usersService.delete(users_id);
    }

    @PutMapping("/restore/{users_id}")
    public void restore(@PathVariable Long users_id) {
        usersService.restore(users_id);
    }

}
