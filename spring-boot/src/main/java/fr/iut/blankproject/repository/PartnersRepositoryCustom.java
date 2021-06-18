package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.Partner;
import fr.iut.blankproject.domain.User;

import java.util.List;

public interface PartnersRepositoryCustom {

    /**
     * Récupère un partenaire selon son nom (avec son compte correspondant)
     * @param name correspond au nom
     * @return une liste de partenaires
     */
    List<Partner> findAccountByName(String name);
}
