package com.report.softserve.repository;

import com.report.softserve.model.BaseEntity;

public interface FileRepository<E extends BaseEntity<ID>,ID> {
    boolean saveToFile(E e);
    boolean deleteFromFile(ID id);
}
