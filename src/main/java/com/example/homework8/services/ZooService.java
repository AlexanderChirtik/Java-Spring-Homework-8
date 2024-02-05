package com.example.homework8.services;

import com.example.homework8.aspect.TrackUserAction;
import com.example.homework8.domain.Animal;
import com.example.homework8.repository.ZooRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс для организации работы с репозиторием. Конструктор не создается,
 * переменная zooRepository заполняется аннотацией @AllArgsConstructor.
 */
@Service
@AllArgsConstructor
public class ZooService {

    /**
     * Создание объекта класса ZooRepository для использования методов
     */
    private ZooRepository zooRepository;

    /**
     * Метод берет из репозитория метод findAll() для получения всех животных.
     * @return Возвращает список всех животных из БД.
     */
    @TrackUserAction
    public List<Animal> findAllAnimals(){
        return zooRepository.findAll();
    }

    /**
     * Метод берет из репозитория метод save() для внесения нового животного в базу данных.
     * @param animal В качетсве параметра принимается объект класса Animal.
     */
    @TrackUserAction
    public void saveAnimal(Animal animal){
        zooRepository.save(animal);
    }

    /**
     * Вызов метода deleteById из репозитория для удаления определенного животного из списка.
     * @param id В качестве аргумента принимается порядкой номер животного в базе данных.
     */
    @TrackUserAction
    public void deleteById(int id) {
        zooRepository.deleteById(id);
    }

    /**
     * Вызов метода update из репозитория для изменения всех данных о животном по его id.
     * @param animal Принимает в качестве аргумента новый объект класса Animal.
     */
    @TrackUserAction
    public void updateAnimal(Animal animal) {
        zooRepository.update(animal);
    }
}
