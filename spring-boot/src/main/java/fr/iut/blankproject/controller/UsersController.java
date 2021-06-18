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

    /**
     * Récupère tout les utilisateurs
     * @return une liste d'utilisateurs
     */
    @GetMapping("/users")
    public List<User> list() {
        return repository.findAll();
    }

    /**
     * Récupère un utilisateur selon son identifiant
     * @param username correspond à l'identifiant
     * @return une liste d'utilisateurs
     */
    @GetMapping("/getUser")
    public List<User> listByUsername(@RequestParam(required = false) String username) {
        return repository.findByUsername(username);
    }

    /**
     * Créer un utilisateur
     * @param entity correspond à l'utilisateur
     * @return une liste d'utilisateurs
     */
    @PostMapping("/user")
    public User insert(@RequestBody User entity) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        return repository.save(entity);
    }

    /**
     * Met à jour un utilisateur selon son "_id"
     * @param entity correspond à l'utilisateur
     * @param id correspond à _id
     * @return une liste d'utilisateurs
     */
    @PutMapping("/userUpdate/{id}")
    public User update(@RequestBody User entity, @PathVariable String id) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        entity.setId(new ObjectId(id));
        return repository.save(entity);
    }

    /**
     * Supprimer un utilisateur selon son "_id"
     * @param id correspond à _id
     * @return une liste d'utilisateurs
     */
    @DeleteMapping("/userDelete/{id}")
    public boolean delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
        return true;
    }
}
