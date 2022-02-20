package com.report.softserve.service.commands.Employee;

import com.report.softserve.model.Employee;
import com.report.softserve.service.commands.Command;
import com.report.softserve.service.commands.CrudCommand;
import com.report.softserve.view.View;

import java.util.Map;

public class DeleteEmployee extends CrudCommand<Employee,Long> {
    public DeleteEmployee(View view, Map<String, Command> commands) {
        super(view, commands, Employee.class);
    }

    @Override
    public void process() {
        view.write("type in entity's ID to delete :");
        delete(Long.parseLong(view.read()));
    }

    @Override
    public String description() {
        return ": видалити існуючого працівника";
    }

    @Override
    public String commandName() {
        return "3";
    }
}
