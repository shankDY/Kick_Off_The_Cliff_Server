package ru.Succes.KickOffTheCliff.service;

import ru.Succes.KickOffTheCliff.entity.EntityOfWinter;

import java.util.List;

/**
 * Created by Shank on 29.05.2017.
 */
public interface KC2Service {
    List<EntityOfWinter> getAll(); // метод возвращает список

    EntityOfWinter getByID(long id);// возвращает один объект

  EntityOfWinter save(EntityOfWinter entityOfWinter);// сохраняет объекты

    void remove(long id);// удаляем по id
}
