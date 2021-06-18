package fr.iut.blankproject.repository;

import fr.iut.blankproject.domain.Object;
import fr.iut.blankproject.domain.ObjectCount;

import java.util.List;

public interface ObjectsRepositoryCustom {

    List<Object> findLastAdded();

    List<ObjectCount> countAll();
}
