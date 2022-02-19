package com.report.softserve.repository;

import lombok.SneakyThrows;
import com.report.softserve.model.BaseEntity;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.StringJoiner;

public class FileRepositoryImpl<E extends BaseEntity<ID>, ID> implements FileRepository<E, ID> {

    private final BufferedWriter bw;
    private final BaseRepository<E,ID> br;
    private File file;

    @SneakyThrows
    public FileRepositoryImpl(Class<E> model) {
        this.file = checkIfFileExists(model.getSimpleName());
        this.bw = new BufferedWriter(new FileWriter(file));
        this.br = RepositoryFactory.of(model);
    }

    private File checkIfFileExists(String modelName) {
        String path = "src\\main\\resources\\" + modelName + ".txt";
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
    public void updateFile() {
        List<E> list = br.findAll();
        if (!list.isEmpty()) {
            for (E el: list) {
                saveToFile(el);
            }
        } else {
            bw.write("");
            bw.flush();
            bw.close();
        };
    }


    @SneakyThrows
    private void saveToFile(E e) {
        StringJoiner sj = new StringJoiner(";");
        Field[] declaredFields = e.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            sj.add(String.valueOf(field.get(e)));
        }
        sj.add("\n");
        bw.write(sj.toString());
        bw.flush();
    }
}
