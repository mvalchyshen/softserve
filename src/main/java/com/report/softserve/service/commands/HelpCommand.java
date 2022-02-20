package com.report.softserve.service.commands;

import com.report.softserve.view.View;

import java.util.Map;

public class HelpCommand implements Command{

    private final View view;
    private final Map<String, Command> commands;

    public HelpCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.commands = commands;
    }

    @Override
    public void process() {
        commands.values()
                .forEach(command -> System.out.println(command.commandName()+command.description()));
    }

    @Override
    public String description() {
        return ": допомога";
    }

    @Override
    public String commandName() {
        return "1";
    }
}
