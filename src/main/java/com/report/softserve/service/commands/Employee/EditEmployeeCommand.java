package com.report.softserve.service.commands.Employee;

import com.report.softserve.model.Employee;
import com.report.softserve.service.commands.Command;
import com.report.softserve.service.commands.CrudCommand;
import com.report.softserve.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class EditEmployeeCommand extends CrudCommand<Employee,Long> {

    public EditEmployeeCommand(View view, Map<String, Command> commands) {
        super(view, commands, Employee.class);
    }

    @Override
    public void process() {
        view.write("type in entity's ID you want to edit :");
        Long id = Long.parseLong(view.read());
        try {
            Employee employee = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Entity with such id doesn't exist"));
            Field[] declaredFields = Employee.class.getDeclaredFields();
            view.write("type in field to edit");
            Arrays.stream(declaredFields).forEach(field -> view.write(field.getName()));
            String fieldName = view.read();
            employee.getClass().getField(fieldName).setAccessible(true);
            employee.getClass().getField(fieldName).set(employee,view.read());
            save(employee);
        } catch (RuntimeException | NoSuchFieldException | IllegalAccessException e) {
            view.write("type in another id");
            process();
        }
    }


    @Override
    public String description() {
        return ": редагувати працівника";
    }

    @Override
    public String commandName() {
        return "4";
    }
}
