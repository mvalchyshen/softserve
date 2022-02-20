package com.report.softserve.service.commands.Employee;

import com.report.softserve.model.Department;
import com.report.softserve.model.Employee;
import com.report.softserve.model.Position;
import com.report.softserve.service.commands.Command;
import com.report.softserve.service.commands.CrudCommand;
import com.report.softserve.view.View;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

public class AddEmployeeCommand extends CrudCommand<Employee, Long> {
    public AddEmployeeCommand(View view, Map<String, Command> commands) {
        super(view, commands, Employee.class);
    }

    @Override
    public void process() {
        view.write("To create employee follow the instructions");
        save(createEntity());
    }

    @Override
    public String description() {
        return ": додати нового працівника";
    }

    @Override
    public String commandName() {
        return "2";
    }


    private Employee createEntity() {
        view.write("type in id");
        Long id = Long.parseLong(view.read());
        view.write("type in surname");
        String surname = view.read();
        view.write("type in name");
        String name =view.read();
        view.write("type in fathersName ");
        String fathersName = view.read();
        LocalDate dateOfBirth = getDateOfBirth();
        Position position = getPositionFromConsole();
        Department department = getDepartmentFromConsole();
        view.write("type in room number");
        Integer roomNumber = Integer.parseInt(view.read());
        view.write("type in phone number");
        String phoneNumber = view.read();
        view.write("type in email");
        String email = view.read();
        view.write("type in salary");
        Integer salary = Integer.parseInt(view.read());
        LocalDate firstWorkDay = getFirstWorkDay();
        view.write("type in note");
        String note = view.read();
        return Employee.builder()
                .id(id)
                .surname(surname)
                .name(name)
                .fathersName(fathersName)
                .dateOfBirth(dateOfBirth)
                .position(position)
                .department(department)
                .roomNumber(roomNumber)
                .phoneNumber(phoneNumber)
                .email(email)
                .salary(salary)
                .firstWorkDay(firstWorkDay)
                .note(note)
                .build();
    }

    private LocalDate getFirstWorkDay() {
        view.write("type in first work day","Day : ");
        int day = Integer.parseInt(view.read());
        view.write("Month : ");
        int month = Integer.parseInt(view.read());
        view.write("Year : ");
        int year = Integer.parseInt(view.read());
        return LocalDate.of(year,month,day);
    }

    private Department getDepartmentFromConsole() {
        view.write("type in department : ");
        Arrays.stream(Department.values())
                .forEach(department -> view.write(department.getName()));
        try {
            return Department.getByName(view.read());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            view.write("type in existing position");
            return getDepartmentFromConsole();
        }
    }

    private Position getPositionFromConsole() {
        view.write("type in position: ");
        Arrays.stream(Position.values())
                .forEach(position -> view.write(position.getName()));
        try {
            return Position.getByName(view.read());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            view.write("type in existing position");
            return getPositionFromConsole();
        }
    }

    private LocalDate getDateOfBirth() {
        view.write("Now type date of birth : ","Day (1 - 31) :");
        int day = Integer.parseInt(view.read());
        view.write("Month (1-12) : ");
        int month = Integer.parseInt(view.read());
        view.write("Year : ");
        int year = Integer.parseInt(view.read());
        return LocalDate.of(year,month,day);
    }
}
