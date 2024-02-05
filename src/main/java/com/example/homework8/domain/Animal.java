package com.example.homework8.domain;

import lombok.Data;

/**
 * Класс Animal включает в себя 4 поля (id - порядковый номер в базе данных,
 * name - кличка животного, age - возраст, kind - к какому виду относится.
 * Getters и Setters заполняются создаются с помощью аннотации @Data из библиотеки Lombok.
 */
@Data
public class Animal {
    private int id;
    private String name;
    private int age;
    private String kind;
}
