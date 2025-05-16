package com.invex.APIEmployee.controller.dto;

import com.invex.APIEmployee.entity.enums.JobPosition;
import com.invex.APIEmployee.entity.enums.Sex;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePatchDTO {
    private String firstName;
    private String middleName;
    private String paternalSurname;
    private String maternalSurname;
    private byte age;
    private Sex sex;
    private LocalDate birthDate;
    private JobPosition jobPosition;
}
