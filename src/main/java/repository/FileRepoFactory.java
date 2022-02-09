package repository;

import model.BaseEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileRepoFactory {
    private final static Map<String, FileRepository> REPOSITORIES = new ConcurrentHashMap<>();

    public synchronized static <E extends BaseEntity<ID>, R extends FileRepository<E, ID>, ID> FileRepository<E, ID> of(Class<E> className) {
        final String modelName = className.getName();
        if (!REPOSITORIES.containsKey(modelName)) {
            REPOSITORIES.put(modelName, new FileRepositoryImpl(className));
        }
        return REPOSITORIES.get(modelName);
    }
}
