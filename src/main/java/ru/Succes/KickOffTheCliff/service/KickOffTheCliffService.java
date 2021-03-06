package ru.Succes.KickOffTheCliff.service;

import ru.Succes.KickOffTheCliff.entity.CoordinatesSummer;
import ru.Succes.KickOffTheCliff.entity.CoordinatesWinter;
import ru.Succes.KickOffTheCliff.entity.EntityOfSummer;
import ru.Succes.KickOffTheCliff.entity.EntityOfWinter;

import java.util.List;


public interface KickOffTheCliffService {
    /** для летних видов спорта**/
    List<EntityOfSummer> getAllSummer(); // метод возвращает список для летнего спорта
    EntityOfSummer getByIDSummer(long id);// возвращает один объект из списка летнего спорта
    EntityOfSummer saveSummer(EntityOfSummer entityOfSummer);// сохраняет объекты для летнего спорта
    void removeSummer(long id);//удаляем элемент из списка летнего спорта



    /** для зимних видов спорта**/
    List<EntityOfWinter> getAllWinter();
    EntityOfWinter getByIDWinter(long id);
    EntityOfWinter saveWinter(EntityOfWinter entityOfWinter);
    void removeWinter(long id);

    /** для таблицы coordinatesSummer**/
    List<CoordinatesSummer> getAllSummerCoordinates();
    CoordinatesSummer getByIDSummerCoordinates(long id);
    CoordinatesSummer saveSummerCoordinates(CoordinatesSummer coordinatesSummer);
    void removeSummerCoordinates(long id);


    /** для таблицы coordinatesWinter**/
    List<CoordinatesWinter> getAllWinterCoordinates();
    CoordinatesWinter getByIDWinterCoordinates(long id);
    CoordinatesWinter saveWinterCoordinates(CoordinatesWinter coordinatesWinter);
    void removeWinterCoordinates(long id);



}
