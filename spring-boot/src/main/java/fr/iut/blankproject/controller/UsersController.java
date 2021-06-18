package fr.iut.blankproject.controller;

import fr.iut.blankproject.domain.User;
import fr.iut.blankproject.repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    private final UsersRepository repository;

    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> list() {
        return repository.findAll();
    }

    @GetMapping("/getUser")
    public List<User> listByUsername(@RequestParam(required = false) String username) {
        return repository.findByUsername(username);
    }

    @PostMapping("/user")
    public User insert(@RequestBody User entity) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        return repository.save(entity);
    }

    @PutMapping("/userUpdate/{id}")
    public User update(@RequestBody User entity, @PathVariable String id) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        entity.setId(new ObjectId(id));
        return repository.save(entity);
    }

    @DeleteMapping("/userDelete/{id}")
    public boolean delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
        return true;
    }
}
