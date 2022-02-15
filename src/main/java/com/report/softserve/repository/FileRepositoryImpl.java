package com.report.softserve.repository;

import lombok.SneakyThrows;
import com.report.softserve.model.BaseEntity;

import java.io.*;
import java.lang.reflect.Field;
import java.util.StringJoiner;

public class FileRepositoryImpl<E extends BaseEntity<ID>, ID> implements FileRepository<E, ID> {

    private final BufferedReader bf;
    private final BufferedWriter bw;
    private File file;

    @SneakyThrows
    public FileRepositoryImpl(Class<E> model) {
        this.file = checkIfFileExists(model.getSimpleName());
        this.bf = new BufferedReader(new FileReader(file));
        this.bw = new BufferedWriter(new FileWriter(file));
    }

    private File checkIfFileExists(String modelName) {
        String path = "src\\main\\resources\\"+modelName+".txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    @Override
    @SneakyThrows
    public boolean saveToFile(E e) {
        StringJoiner sj = new StringJoiner(";");
        Field[] declaredFields = e.getClass().getDeclaredFields();
        for (Field field: declaredFields) {
            field.setAccessible(true);
            sj.add(String.valueOf(field.get(e)));
        }
        sj.add("\n");
        bw.write(sj.toString());
        bw.flush();
        return false;
    }

    @Override
    public boolean deleteFromFile(ID id) {
        return false;
    }
}
