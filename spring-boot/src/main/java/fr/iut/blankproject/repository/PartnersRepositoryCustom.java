package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.Partner;
import fr.iut.blankproject.domain.User;

import java.util.List;

public interface PartnersRepositoryCustom {

    List<Partner> findAccountByName(String name);
}
