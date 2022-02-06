package model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements BaseEntity<UUID> {

    private UUID id;
    private String surname;
    private String name;
    private String fathersName;
    private LocalDate dateOfBirth;
    private Position position;
    private Department department;
    private Integer roomNumber;
    private Integer phoneNumber;
    private String email;
    private Integer salary;
    private LocalDate firstWorkDay;
    private String note;
}
