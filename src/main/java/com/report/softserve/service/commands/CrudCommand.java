package com.report.softserve.service.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.softserve.model.BaseEntity;
import com.report.softserve.repository.BaseRepository;
import com.report.softserve.repository.FileRepository;
import com.report.softserve.repository.FileRepositoryImpl;
import com.report.softserve.repository.RepositoryFactory;
import com.report.softserve.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;


public abstract class CrudCommand<E extends BaseEntity<ID>, ID> implements Command {
    protected final View view;
    protected final Map<String, Command> commands;
    private final BaseRepository<E, ID> repository;
    private final FileRepository<E, ID> fileRepository;
    private final Class<E> className;


    public CrudCommand(View view, Map<String, Command> commands, Class<E> className) {
        this.view = view;
        this.commands = commands;
        this.className = className;
        this.repository = RepositoryFactory.of(className);
        this.fileRepository = new FileRepositoryImpl<>(className);

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

    protected void delete(ID id) {
        repository.delete(id);
        this.updateFile();
    }

    private void sendResult(boolean present, Object item) {
        if (present) view.write(item);
        else view.write("No element with such id was found");
    }

    private Set<String> getFieldsName() {
        return Arrays.stream(className.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .map(Field::getName)
                .collect(Collectors.toSet());
    }

    private void updateFile() {
        fileRepository.updateFile();
    }

}
