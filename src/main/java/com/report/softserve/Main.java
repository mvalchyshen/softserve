package com.report.softserve;

import com.report.softserve.controller.ConsoleController;
import com.report.softserve.view.ViewImpl;

public class Main {

    public static void main(String[] args) {
        new ConsoleController(new ViewImpl()).proceed();
    }
}
