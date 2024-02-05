package com.example.homework8.repository;

import com.example.homework8.domain.Animal;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс ZooRepository создан для взаимодействия с базой данных и подключается к ней при помощи класса JdbcTemplate.
 * Конструктор не создается, переменная jdbc заполняется аннотацией @AllArgsConstructor.
 */
@Repository
@AllArgsConstructor
public class ZooRepository {

    /**
     * Поле jdbc для подключения к базе данных
     */
    private final JdbcTemplate jdbc;

    /**
     * Метод позволяет зайти в базу данных и получить от туда всех животных.
     * Создается контакт с БД, затем в неё передается запрос.
     * @return Возвращает список всех животных в базе
     */
    public List<Animal> findAll() {
        String sql = "SELECT * FROM zooTable";

        RowMapper<Animal> animalRowMapper = (r, i) -> {
            Animal rowObject = new Animal();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setKind(r.getString("kind"));
            return rowObject;
        };

        return jdbc.query(sql, animalRowMapper);
    }

    /**
     * Метод добавления животного в базу данных. Создается контакт с БД.
     * В неё передается запрос на SQL и поля от полученного животного, которые нужно вставить в таблицу.
     * @param animal В качестве параметра принимает новое животное
     */
    public void save(Animal animal) {
        String sql = "INSERT INTO zooTable (name, age, kind) VALUES (?, ?, ?)";
        jdbc.update(sql, animal.getName(), animal.getAge(), animal.getKind());
    }

    /**
     * Метод удаляет животное из списка по его порядковому номеру из базы данных.
     * @param id Принимает номер, который будет найден в БД.
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM zooTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Метод изменяет данные у одного элемента таблицы в БД. По номеру id ищется животное.
     * В данной реализации метода предусмотрена замена только всех полей одновременно.
     * @param animal Принимает в качестве аргумента новый объект класса Animal.
     * Из него в запрос с помощью геттеров вставляются нужные параметры.
     */
    public void update(Animal animal) {
        String sql = "UPDATE zooTable SET name=?, age=?, kind =? WHERE id=?";
        jdbc.update(sql, animal.getName(), animal.getAge(), animal.getKind(), animal.getId());
    }
}

