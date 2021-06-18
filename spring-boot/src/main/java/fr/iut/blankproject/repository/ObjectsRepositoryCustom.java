package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.ObjectCount;

import java.util.List;

public interface ObjectsRepositoryCustom {

    /**
     * Récupère le dernier objet (selon la date de création)
     * @return une liste d'objets
     */
    List<Object> findLastAdded();

    /**
     * Récupère les groupes d'objets ayant la même couleur et donne leur nombre
     * @return une liste d'objets groupé par couleur (uniquement couleur et nombre total)
     */
    List<ObjectCount> countAll();
}
