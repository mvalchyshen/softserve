package com.report.softserve.repository;

import com.report.softserve.model.BaseEntity;

public interface FileRepository<E extends BaseEntity<ID>,ID> {
    void updateFile();

    static <E> FileRepository of(Class<E> eClass){
        return new FileRepositoryImpl(eClass);
    }
}
