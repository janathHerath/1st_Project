package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MS_USE_TEST")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int birth_year;

    public User(int id, String name, int birth_year) {
        this.id = id;
        this.name = name;
        this.birth_year = birth_year;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirth_year() {

        return birth_year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    @Override
    public String toString() {
        return "userDTO{" +
                "IdentityNumber='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth year='" + birth_year + '\'' +
                '}';
    }
}