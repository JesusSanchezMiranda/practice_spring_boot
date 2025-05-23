package pe.edu.vallegrande.elsabroson.service.impl;

import pe.edu.vallegrande.elsabroson.model.Users;   
import pe.edu.vallegrande.elsabroson.repository.UsersRepository;
import pe.edu.vallegrande.elsabroson.service.UsersService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService {
    

    private final UsersRepository usersRepository;


    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    } 

    @Override
    public List<Users> findAll() {
        log.info("Listado de datos: ");
        return usersRepository.findAll();
    } 


    @Override
    public Optional<Users> findById(Integer users_id) {
        log.info("Listado datos por ID: ");
        return usersRepository.findById(users_id);
    }

    @Override
    public List<Users> findByState(boolean state) {
        log.info("Listado de datos por estado: ");
        return usersRepository.findByState(state); // corregido
    }

    @Override
    public Users save(Users users) {
        log.info("Registro de Datos: " + users.toString());
        return usersRepository.save(users);
    }


    @Override
    public Users update(Users users) {
        log.info("Editado de Datos: " + users.toString());
        return usersRepository.save(users);
    }

    @Override
    public void delete(Integer users_id) {
        log.info("Listado datos por ID: ");
        Optional<Users> users= usersRepository.findById(users_id);
        users.ifPresent(
            em->{em.setState("I");
            usersRepository.save(em);}
        );
    }


    @Override
    public void restore(Integer users_id) {
        log.info("Listado Datos por ID: ");
        Optional<Users> users= usersRepository.findById(users_id);
        users.ifPresent(
            em->{em.setState("A");
            usersRepository.save(em);}
        );
    }



}
