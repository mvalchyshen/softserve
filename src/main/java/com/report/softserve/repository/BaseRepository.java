package com.report.softserve.repository;

import com.report.softserve.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {
    E save(E e);

    List<E> saveAll(Iterable<E> itr);

    Optional<E> findById(ID id);

    List<E> findAll();

    void delete(ID id);
}
