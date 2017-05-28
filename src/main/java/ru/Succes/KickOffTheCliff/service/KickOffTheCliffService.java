package ru.Succes.KickOffTheCliff.service;

import ru.Succes.KickOffTheCliff.entity.EntityOfSummer;

import java.util.List;


public interface KickOffTheCliffService {
    List<EntityOfSummer> getAll(); // метод возвращает список

    EntityOfSummer getByID(long id);// возвращает один объект

    EntityOfSummer save(EntityOfSummer entityOfSummer);// сохраняет объекты

    void remove(long id);// удаляем по id
}
