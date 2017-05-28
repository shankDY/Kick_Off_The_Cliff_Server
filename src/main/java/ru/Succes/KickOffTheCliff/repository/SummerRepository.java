package ru.Succes.KickOffTheCliff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Succes.KickOffTheCliff.entity.EntityOfSummer;

/*нужен для того, чтобы работать с нашей таблицей в базе данных, оперируя java объектами .  в нашем случае remind object*/
/*первый параметр отвечает за возвращаемый объект, второй за тип сущности, в нашем случае это long, поэтому указываем оберточный Long*/
public interface SummerRepository extends JpaRepository<EntityOfSummer,Long> {
}
