package com.example.homework8.controllers;


import com.example.homework8.domain.Animal;
import com.example.homework8.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс осуществляет взаимодействие в интерфейсом приложения,
 * получает запросы и вызывает подходящие под них методы из класса ZooService.
 * Подключение осуществляется по адресу http://localhost:8080/zoo
 */
@Controller
@RequestMapping
public class ZooController {

    /**
     * Создание экземпляра класса ZooService для использования методов данного класса.
     * Заполняется автоматически благодаря аннотации @Autowired
     */
    @Autowired
    private ZooService service;

    /**
     * При вводе в браузер адреса http://localhost:8080/zoo метод getZooList() вызывает у переменной
     * service метод findAllAnimals() для получения списка всех животных. С помощью класса Model и механизама Thymeleaf
     * полученный список автоматически вставляется в html-файл zoo. Данная страница с уже заполненными данными
     * возвращается в браузер.
     * @param model Принимает экземпляр класса Model из библиотеки org.springframework.
     * @return Возвращает заполненный данными zoo.html.
     */
    @GetMapping("/zoo")
    public String getZooList(Model model) {
        model.addAttribute("animals", service.findAllAnimals());
        return "zoo";
    }

    /**
     * При отправлении данных на странице http://localhost:8080/zoo через кнопку "Добавить в зоопарк" полученные данные
     * через метод сервиса saveAnimal() добавляются в базу данных. Затем у service вызывается метод findAllAnimals() для
     * получения списка всех животных. С помощью класса Model и механизама Thymeleaf полученный список автоматически
     * вставляется в html-файл zoo. Данная страница с обновленными данными возвращается в браузер.
     * @param animal Данные нового животного, которые автоматически преобразуются в объект класс Animal благодаря
     * совпадению названий полей.
     * @param model Принимает экземпляр класса Model из библиотеки org.springframework для заполнения html-файла.
     * @return Возвращает заполненный данными zoo.html.
     */
    @PostMapping("/zoo")
    public String addAnimal(Animal animal, Model model) {
        service.saveAnimal(animal);
        model.addAttribute("animals", service.findAllAnimals());
        return "zoo";
    }

    /**
     * Через форму на странице zoo.html в формате post отправляются данные на адрес http://localhost:8080/zoo/delete.
     * Аннотация @PostMapping принимает полученное число и вызывает у сервиса метод deleteById, передавая в него номер
     * животного в базе данных. Затем у service вызывается метод findAllAnimals() для получения списка всех животных.
     * С помощью класса Model и механизама Thymeleaf полученный список автоматическивставляется в html-файл zoo.
     * Данная страница с обновленными данными возвращается в браузер.
     * @param id Принимает число из формы на странице zoo.html.
     * @param model Принимает экземпляр класса Model из библиотеки org.springframework для заполнения html-файла.
     * @return Возвращает заполненный данными zoo.html.
     */
    @PostMapping("/zoo/delete")
    public String deleteAnimal(int id, Model model) {
        service.deleteById(id);
        model.addAttribute("animals", service.findAllAnimals());
        return "zoo";
    }

    /**
     * Через форму на странице zoo.html в формате post отправляются данные на адрес http://localhost:8080/zoo/update.
     * Аннотация @PostMapping принимает данные о животном и вызывает у сервиса метод updateAnimal, передавая в него
     * объект класса Animal. Затем у service вызывается метод findAllAnimals() для получения списка всех животных.
     * С помощью класса Model и механизама Thymeleaf полученный список автоматическивставляется в html-файл zoo.
     * Данная страница с обновленными данными возвращается в браузер.
     * @param animal Данные нового животного, которые автоматически преобразуются в объект класс Animal благодаря
     * совпадению названий полей.
     * @param model Принимает экземпляр класса Model из библиотеки org.springframework для заполнения html-файла.
     * @return Возвращает заполненный данными zoo.html.
     */
    @PostMapping("/zoo/update")
    public String updateAnimal(Animal animal, Model model) {
        service.updateAnimal(animal);
        model.addAttribute("animals", service.findAllAnimals());
        return "zoo";
    }
}
