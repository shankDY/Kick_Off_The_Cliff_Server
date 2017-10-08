package ru.Succes.KickOffTheCliff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Succes.KickOffTheCliff.entity.CoordinatesWinter;

public interface WinterCoordinatesRepository extends JpaRepository<CoordinatesWinter,Long> {
}
