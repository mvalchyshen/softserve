package repository;

import model.BaseEntity;

import java.util.List;

public interface FileRepository<E extends BaseEntity<ID>,ID> {
    boolean saveToFile(E e);
    boolean deleteFromFile(ID id);
}
