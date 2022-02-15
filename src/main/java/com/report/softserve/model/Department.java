package com.report.softserve.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum Department {
    IOC("Інформаційний обчислювальний центр (ІОЦ)");
    @Getter
    private String name;

}
