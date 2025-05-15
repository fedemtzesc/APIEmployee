package com.invex.APIEmployee.entity;

import com.invex.APIEmployee.entity.enums.JobPosition;
import com.invex.APIEmployee.entity.enums.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="e_employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(nullable = false, length = 20)
    private String middleName;
    @Column(nullable = false, length = 30)
    private String paternalSurname;
    @Column(nullable = false, length = 30)
    private String maternalSurname;
    @Column(nullable = false)
    private byte age;
    @Column(nullable = false)
    private Sex sex;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private JobPosition jobPosition;
}
