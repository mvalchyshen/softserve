package com.report.softserve.controller;

import com.report.softserve.service.commands.Command;
import com.report.softserve.view.View;

import java.util.Map;
import java.util.Optional;

public class ConsoleController {
    private final View view;
    private final Map<String, Command> commands;

    public ConsoleController(View view) {
        this.view = view;
        this.commands = Command.of(view);
    }

    public void proceed() {
        view.write("WELCOME!!!");
        while (true) {
            view.write("write 5 for help");
            Optional.ofNullable(commands.get(view.read())).ifPresent(Command::process);
        }
    }

}
