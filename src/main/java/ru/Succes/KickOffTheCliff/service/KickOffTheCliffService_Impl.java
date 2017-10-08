package ru.Succes.KickOffTheCliff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Succes.KickOffTheCliff.entity.CoordinatesSummer;
import ru.Succes.KickOffTheCliff.entity.CoordinatesWinter;
import ru.Succes.KickOffTheCliff.entity.EntityOfSummer;
import ru.Succes.KickOffTheCliff.entity.EntityOfWinter;
import ru.Succes.KickOffTheCliff.repository.SummerCoordinatesRepository;
import ru.Succes.KickOffTheCliff.repository.SummerRepository;
import ru.Succes.KickOffTheCliff.repository.WinterCoordinatesRepository;
import ru.Succes.KickOffTheCliff.repository.WinterRepository;

import java.util.List;

/**
 *  Hеализация наших методов для работы с бд*
 * сервисный слой , который предоставляет возможность работы с логикой приложения , с нашим KickOffTheCliffController
 * Так глуппо работать с контролером напрямую. Потому, что мы можем иметь несколько репозитори.  И данная реализация просто упростит нам жизнь
 * Тут уже можно подключать наши репоситории.
 * Здесь мы реализуем всю бизнесс логику нашего приложения. А контролеры их просто вызывают
 */

@Service
public class KickOffTheCliffService_Impl implements KickOffTheCliffService {

    @Autowired
    private SummerRepository repository;
    @Autowired
    private WinterRepository winterRepository;
    @Autowired
    SummerCoordinatesRepository summerCoordinatesRepository;
    @Autowired
    WinterCoordinatesRepository winterCoordinatesRepository;

    //таблица summer
    //получаем все записи
    public List<EntityOfSummer> getAllSummer() {
        return repository.findAll();
    }

    //получаем одну запись
    public EntityOfSummer getByIDSummer(long id) {
        return repository.findOne(id);
    }

    //записываем(обновляем) наши объекты
    public EntityOfSummer saveSummer(EntityOfSummer entityOfSummer) {
        return repository.saveAndFlush(entityOfSummer);
    }

    //удаляем наши записи по id
    public void removeSummer(long id) {
        repository.delete(id);
    }



    //таблица winter
    public List<EntityOfWinter> getAllWinter() {
        return winterRepository.findAll();
    }
    public EntityOfWinter getByIDWinter(long id) {
        return winterRepository.findOne(id);
    }
    public EntityOfWinter saveWinter(EntityOfWinter entityOfWinter) {
        return winterRepository.saveAndFlush(entityOfWinter);
    }
    public void removeWinter(long id) {
        winterRepository.delete(id);
    }


    //таблица coordinatesSummer
    public List<CoordinatesSummer> getAllSummerCoordinates() {
        return summerCoordinatesRepository.findAll();
    }
    public CoordinatesSummer getByIDSummerCoordinates(long id) {
        return summerCoordinatesRepository.findOne(id);
    }

    public CoordinatesSummer saveSummerCoordinates(CoordinatesSummer coordinatesSummer) {
        return summerCoordinatesRepository.saveAndFlush(coordinatesSummer);
    }
    public void removeSummerCoordinates(long id) {
        summerCoordinatesRepository.delete(id);
    }




    //таблица coordinatesWinter
    public List<CoordinatesWinter> getAllWinterCoordinates() {
        return winterCoordinatesRepository.findAll();
    }

    public CoordinatesWinter getByIDWinterCoordinates(long id) {
        return winterCoordinatesRepository.findOne(id);
    }

    public CoordinatesWinter saveWinterCoordinates(CoordinatesWinter coordinatesWinter) {
        return winterCoordinatesRepository.saveAndFlush(coordinatesWinter);
    }

    public void removeWinterCoordinates(long id) {
        winterCoordinatesRepository.delete(id);

    }


}

