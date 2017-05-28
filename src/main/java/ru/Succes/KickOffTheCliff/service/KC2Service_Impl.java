package ru.Succes.KickOffTheCliff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Succes.KickOffTheCliff.entity.EntityOfWinter;
import ru.Succes.KickOffTheCliff.repository.WinterRepository;

import java.util.List;

@Service
public class KC2Service_Impl implements KC2Service {

    @Autowired
    private WinterRepository repository;

   /*реализация наших методов для работы с бд*/

    //получаем все записи
    public List<EntityOfWinter> getAll() {
        return repository.findAll();
    }

    //получаем одну запись
    public EntityOfWinter getByID(long id) {
        return repository.findOne(id);
    }

    //записываем(обновляем) наши объекты
    public EntityOfWinter save(EntityOfWinter entityOfWinter) {
        return repository.saveAndFlush(entityOfWinter);
    }

    //удаляем наши записи по id
    public void remove(long id) {
        repository.delete(id);
    }
}
