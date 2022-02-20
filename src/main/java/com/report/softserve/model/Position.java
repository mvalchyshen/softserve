package com.report.softserve.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public enum Position {
    DEV("Розробник"),
    ADMINISTRATOR("Адміністратор");
    @Getter
    private String name;

    public static Position getByName(String name) throws Exception {
        return Arrays.stream(Position.values())
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new Exception("No Such Position found"));
    }
}
