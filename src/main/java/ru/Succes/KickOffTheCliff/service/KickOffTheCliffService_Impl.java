package ru.Succes.KickOffTheCliff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Succes.KickOffTheCliff.entity.EntityOfSummer;
import ru.Succes.KickOffTheCliff.repository.SummerRepository;

import java.util.List;

/**
 * сервисный слой , который предоставляет возможность работы с логикой приложения , с нашим ReminderController
 * Так глуппо работать с контролером напрямую. Потому, что мы можем иметь несколько репозитори.  И данная реализация просто упростит нам жизнь
 * Тут уже можно подключать наши репоситории.
 * Здесь мы реализуем всю бизнесс логику нашего приложения. А контролеры их просто вызывают
 */
@Service
public class KickOffTheCliffService_Impl implements KickOffTheCliffService {

    @Autowired
    private SummerRepository repository;

    /*реализация наших методов для работы с бд*/

    //получаем все записи
    public List<EntityOfSummer> getAll() {
        return repository.findAll();
    }

    //получаем одну запись
    public EntityOfSummer getByID(long id) {
        return repository.findOne(id);
    }

    //записываем(обновляем) наши объекты
    public EntityOfSummer save(EntityOfSummer entityOfSummer) {
        return repository.saveAndFlush(entityOfSummer);
    }

    //удаляем наши записи по id
    public void remove(long id) {
        repository.delete(id);
    }
}
