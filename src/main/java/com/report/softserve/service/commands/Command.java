package com.report.softserve.service.commands;

import com.report.softserve.view.View;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.*;

public interface Command {
    void process();

    String description();

    String commandName();

    @SneakyThrows
    static Map<String, Command> of(View view) {
        Set<Class<? extends Command>> commandClasses = new Reflections("com.report.softserve")
                .getSubTypesOf(Command.class);
        Map<String, Command> commands = new LinkedHashMap<>(commandClasses.size());
        for (Class<? extends Command> commandClass : commandClasses) {
            if (Modifier.isAbstract(commandClass.getModifiers()) || commandClass.isInterface()) continue;
            Command command = commandClass.getConstructor(View.class, Map.class).newInstance(view, commands);
            commands.put(command.commandName(), command);

        }
        return commands;
    }
}
