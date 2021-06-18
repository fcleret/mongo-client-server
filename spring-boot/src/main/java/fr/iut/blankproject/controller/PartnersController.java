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

    /**
     * Récupère tout les partenaires
     * @return une liste de partenaires
     */
    @GetMapping("/partners")
    public List<Partner> list() {
        return repository.findAll();
    }

    /**
     * Récupère un partenaire selon son nom
     * @param name correspond au nom
     * @return une liste de partenaires
     */
    @GetMapping("/getPartner")
    public List<Partner> listByName(@RequestParam(required = false) String name) {
        return repository.findByName(name);
    }

    /**
     * Récupère un partenaire selon son nom (avec son compte correspondant)
     * @param name correspond au nom
     * @return une liste de partenaires
     */
    @GetMapping("/getPartner/account")
    public List<Partner> listAccountByName(@RequestParam(required = false) String name) {
        return repository.findAccountByName(name);
    }

    /**
     * Créer un partenaire
     * @param entity correspond au partenaire
     * @return une liste de partenaires
     */
    @PostMapping("/partner")
    public Partner insert(@RequestBody Partner entity) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        return repository.save(entity);
    }

    /**
     * Met à jour un partenaire selon son "_id"
     * @param entity correspond au partenaire
     * @param id correspond à _id
     * @return une liste de partenaires
     */
    @PutMapping("/partnerUpdate/{id}")
    public Partner update(@RequestBody Partner entity, @PathVariable String id) {
        if (entity == null) {
            throw new CustomException("Must be not null");
        }
        entity.setId(new ObjectId(id));
        return repository.save(entity);
    }

    /**
     * Supprimer un partenaire selon son "_id"
     * @param id correspond à _id
     * @return une liste de partenaires
     */
    @DeleteMapping("/partnerDelete/{id}")
    public boolean delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
        return true;
    }
}
