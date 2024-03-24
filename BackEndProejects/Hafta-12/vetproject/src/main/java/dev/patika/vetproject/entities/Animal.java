package dev.patika.vetproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table( name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", columnDefinition = "serial")
    private long id;
    @NotNull
    @Column (name = "animal_name")
    private String name;
    @NotNull
    @Column (name = "animal_species")
    private String species;
    @NotNull
    @Column (name = "animal_breed")
    private String breed;

    @Enumerated(EnumType.STRING) // enum oldugunu ve string oldugunu söylüyoruz
    @Column(name = "animal_gender")
    private GENDER gender;

    public enum GENDER {
        MALE,
        FEMALE
    }

    @Column (name = "animal_colour")
    private String colour;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "animal_on_date")
    private LocalDate onDate;

}


