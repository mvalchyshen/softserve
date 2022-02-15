package com.report.softserve.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Position {
    DEV("Розробник"),
    ADMINISTRATOR("Адміністратор");
    @Getter
    private String name;
}
