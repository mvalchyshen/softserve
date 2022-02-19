package com.report.softserve.service.commands.Employee;

import com.report.softserve.model.Employee;
import com.report.softserve.service.commands.Command;
import com.report.softserve.service.commands.CrudCommand;
import com.report.softserve.view.View;

import java.util.Map;

public class EditEmployeeCommand extends CrudCommand<Employee,Long> {

    public EditEmployeeCommand(View view, Map<String, Command> commands) {
        super(view, commands, Employee.class);
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
