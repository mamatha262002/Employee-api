package org.example.employee_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Entity
@Table(name = "employee1")
@Data //Data is used to get the default getters and setters methods
@NoArgsConstructor //It tells lombook to generate the no arguments constructor for the class
@AllArgsConstructor
public class employee1
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",length = 50, nullable = false)
    private String first_name;

    @Column(name = "last_name",length = 50, nullable = false)
    private String last_name;

    @Column(length  = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 50)
    private String department;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;
}
