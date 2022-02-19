package com.report.softserve.service.commands;

import com.report.softserve.model.BaseEntity;
import com.report.softserve.repository.BaseRepository;
import com.report.softserve.repository.FileRepository;
import com.report.softserve.repository.FileRepositoryImpl;
import com.report.softserve.repository.RepositoryFactory;
import com.report.softserve.view.View;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public abstract class CrudCommand<E extends BaseEntity<ID>, ID> implements Command {
    private final View view;
    private final Map<String, Command> commands;
    private final BaseRepository<E, ID> repository;
    private final FileRepository<E, ID> fileRepository;
    private final Class<E> className;

    public CrudCommand(View view, Map<String, Command> commands, Class<E> className) {
        this.view = view;
        this.commands = commands;
        this.className = className;
        repository = RepositoryFactory.of(className);
        fileRepository = new FileRepositoryImpl<>(className);
    }

    protected void save(E e) {
        E save = repository.save(e);
        this.updateFile();
    }

    protected void saveAll(Iterable<E> itr) {
        List<E> result = repository.saveAll(itr);
        this.updateFile();

    }

    protected void findById(ID id) {
        Optional<E> item = repository.findById(id);
        sendResult(item.isPresent(), item);
    }

    protected void findAll() {
        List<E> all = repository.findAll();
        sendResult(!all.isEmpty(), all);
    }

    protected void delete(ID id){
        repository.delete(id);
        this.updateFile();
    }

    private void sendResult(boolean present, Object item) {
        if (present) view.write(item);
        else view.write("No element with such id was found");
    }

    private void updateFile(){
        fileRepository.updateFile();
    }

}
