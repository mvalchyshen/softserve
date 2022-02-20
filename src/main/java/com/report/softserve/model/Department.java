package com.report.softserve.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor

public enum Department {
    IOC("Інформаційний обчислювальний центр (ІОЦ)");
    @Getter
    private String name;

    public static Department getByName(String name) throws Exception {
        return Arrays.stream(Department.values())
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new Exception("No Such Position found"));
    }
}
