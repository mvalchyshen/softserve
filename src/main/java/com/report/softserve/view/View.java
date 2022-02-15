package com.report.softserve.view;

public interface View {
    String readCommand();
    void write(Object... objs);
}
