package com.report.softserve.service.commands.Employee;

import com.report.softserve.model.Employee;
import com.report.softserve.service.commands.Command;
import com.report.softserve.service.commands.CrudCommand;
import com.report.softserve.view.View;

import java.util.Map;

public class FindEmployee extends CrudCommand<Employee,Long> {
    public FindEmployee(View view, Map<String, Command> commands, Class<Employee> className) {
        super(view, commands, className);
    }

    @Override
    public void process() {

    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String commandName() {
        return null;
    }
}
