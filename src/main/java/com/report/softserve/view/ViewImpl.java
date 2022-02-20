package com.report.softserve.view;

import java.util.Arrays;
import java.util.Scanner;

public class ViewImpl implements View{
    private Scanner scanner;

    public ViewImpl() {
        scanner = new Scanner(System.in);
    }
    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(Object... objs) {
        Arrays.stream(objs).forEach(System.out::println);
    }
}
