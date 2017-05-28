package ru.Succes.KickOffTheCliff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Succes.KickOffTheCliff.entity.EntityOfWinter;


public interface WinterRepository extends JpaRepository<EntityOfWinter,Long> {
}
