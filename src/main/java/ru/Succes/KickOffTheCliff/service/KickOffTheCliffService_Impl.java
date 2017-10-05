package ru.Succes.KickOffTheCliff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Succes.KickOffTheCliff.entity.EntityOfSummer;
import ru.Succes.KickOffTheCliff.entity.EntityOfWinter;
import ru.Succes.KickOffTheCliff.repository.SummerRepository;
import ru.Succes.KickOffTheCliff.repository.WinterRepository;

import java.util.List;

/**
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

    /*реализация наших методов для работы с бд*/

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



    //получаем все записи
    public List<EntityOfWinter> getAllWinter() {
        return winterRepository.findAll();
    }

    //получаем одну запись
    public EntityOfWinter getByIDWinter(long id) {
        return winterRepository.findOne(id);
    }

    //записываем(обновляем) наши объекты
    public EntityOfWinter saveWinter(EntityOfWinter entityOfWinter) {
        return winterRepository.saveAndFlush(entityOfWinter);
    }

    //удаляем наши записи по id
    public void removeWinter(long id) {
        winterRepository.delete(id);
    }
}

