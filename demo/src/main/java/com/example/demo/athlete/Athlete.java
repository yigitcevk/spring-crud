package com.example.demo.athlete;

import jakarta.persistence.*; //Look into

import java.time.LocalDate;
import java.time.Period;

@Entity //map this athlete to db
public class Athlete {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "athlete_sequence"
    )
    @SequenceGenerator(
            name = "athlete_sequence",
            sequenceName = "athlete_sequence",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @Transient // no need for column, will be calculated
    private Integer age;
    private LocalDate birthday;
    private Integer height;
    private Integer weight;
    private String gender;

    public Athlete() {
    }

    public Athlete(Long id,
                   String name,
                   LocalDate birthday,
                   Integer height,
                   Integer weight,
                   String gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public Athlete(String name,
                   LocalDate birthday,
                   Integer height,
                   Integer weight,
                   String gender) {
        this.name = name;
        this.height = height;
        this.birthday = birthday;
        this.weight = weight;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                '}';
    }
}
