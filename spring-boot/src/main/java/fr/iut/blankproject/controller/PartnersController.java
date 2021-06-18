package fr.iut.blankproject.controller;

import fr.iut.blankproject.domain.Partner;
import fr.iut.blankproject.domain.User;
import fr.iut.blankproject.repository.PartnersRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartnersController {

    private final PartnersRepository repository;

    public PartnersController(PartnersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/partners")
    public List<Partner> list() {
        return repository.findAll();
    }

    @GetMapping("/getPartner")
    public List<Partner> listByName(@RequestParam(required = false) String name) {
        return repository.findByName(name);
    }

    @GetMapping("/getPartner/account")
    public List<Partner> listAccountByName(@RequestParam(required = false) String name) {
        return repository.findAccountByName(name);
    }

    @PostMapping("/partner")
    public Partner insert(@RequestBody Partner entity) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        return repository.save(entity);
    }

    @PutMapping("/partnerUpdate/{id}")
    public Partner update(@RequestBody Partner entity, @PathVariable String id) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        entity.setId(new ObjectId(id));
        return repository.save(entity);
    }

    @DeleteMapping("/partnerDelete/{id}")
    public boolean delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
        return true;
    }
}
