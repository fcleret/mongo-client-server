package fr.iut.blankproject.controller;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.ObjectCount;
import fr.iut.blankproject.repository.ObjectsRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObjectsController {

    private final ObjectsRepository repository;

    public ObjectsController(ObjectsRepository repository) {
        this.repository = repository;
    }

    /**
     * Récupère tout les objets
     * @return une liste d'objets
     */
    @GetMapping("/objects")
    public List<Object> list() {
        return repository.findAll();
    }

    /**
     * Récupère un objet selon son nom
     * @param name correspond au nom
     * @return une liste d'objets
     */
    @GetMapping("/getObject")
    public List<Object> listByName(@RequestParam(required = false) String name) {
        return repository.findByName(name);
    }

    /**
     * Récupère le dernier objet (selon la date de création)
     * @return une liste d'objets
     */
    @GetMapping("/objects/last")
    public List<Object> lastAdded() {
        return repository.findLastAdded();
    }

    /**
     * Récupère les groupes d'objets ayant la même couleur et donne leur nombre
     * @return une liste d'objets groupé par couleur (uniquement couleur et nombre total)
     */
    @GetMapping("/objects/count")
    public List<ObjectCount> count() {
        return repository.countAll();
    }

    /**
     * Créer un objet
     * @param entity correspond à l'objet
     * @return une liste d'objets
     */
    @PostMapping("/object")
    public Object insert(@RequestBody Object entity) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        return repository.save(entity);
    }

    /**
     * Met à jour un objet selon son "_id"
     * @param entity correspond à l'objet
     * @param id correspond à _id
     * @return une liste d'objets
     */
    @PutMapping("/objectUpdate/{id}")
    public Object update(@RequestBody Object entity, @PathVariable String id) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        entity.setId(new ObjectId(id));
        return repository.save(entity);
    }

    /**
     * Supprimer un objet selon son "_id"
     * @param id correspond à _id
     * @return une liste d'objets
     */
    @DeleteMapping("/objectDelete/{id}")
    public boolean delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
        return true;
    }
}
