package repository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import model.BaseEntity;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseRepositoryImpl<E extends BaseEntity<ID>,ID> implements BaseRepository<E,ID>{
    private final Map<ID,E> STORAGE = new HashMap<>();
    @Override
    public E save(E e) {
        if (Objects.isNull(e)) throw new RuntimeException("It's impossible to save null");
        else return STORAGE.put(e.getId(),e);
    }

    @Override
    public List<E> saveAll(Iterable<E> itr) {
        List<E> list = new ArrayList<>();
        if (Objects.isNull(itr)) return list;
        else for (E e: itr) {
            list.add(this.save(e));
        }
        return list;
    }

    @Override
    public Optional<E> findById(ID id) {
        if (Objects.isNull(id)) return Optional.empty();
        return STORAGE.containsKey(id) ? Optional.of(STORAGE.get(id)) : Optional.empty();
    }

    @Override
    public List<E> findAll() {
        return new ArrayList<>(STORAGE.values());
    }

    @Override
    public void delete(ID id) {
        if (!Objects.isNull(id)) STORAGE.remove(id);
    }
}
