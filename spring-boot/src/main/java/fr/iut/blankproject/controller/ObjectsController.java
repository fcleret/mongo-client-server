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

    @GetMapping("/objects")
    public List<Object> list() {
        return repository.findAll();
    }

    @GetMapping("/getObject")
    public List<Object> listByName(@RequestParam(required = false) String name) {
        return repository.findByName(name);
    }

    @GetMapping("/objects/last")
    public List<Object> lastAdded() {
        return repository.findLastAdded();
    }

    @GetMapping("/objects/count")
    public List<ObjectCount> count() {
        return repository.countAll();
    }

    @PostMapping("/object")
    public Object insert(@RequestBody Object entity) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        return repository.save(entity);
    }

    @PutMapping("/objectUpdate/{id}")
    public Object update(@RequestBody Object entity, @PathVariable String id) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        entity.setId(new ObjectId(id));
        return repository.save(entity);
    }

    @DeleteMapping("/objectDelete/{id}")
    public boolean delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
        return true;
    }
}
