package com.report.softserve.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements BaseEntity<Long> {

    private Long id;
    private String surname;
    private String name;
    private String fathersName;
    private LocalDate dateOfBirth;
    private Position position;
    private Department department;
    private Integer roomNumber;
    private String phoneNumber;
    private String email;
    private Integer salary;
    private LocalDate firstWorkDay;
    private String note;

}
