package ru.Succes.KickOffTheCliff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Succes.KickOffTheCliff.entity.CoordinatesSummer;

public interface SummerCoordinatesRepository extends JpaRepository<CoordinatesSummer,Long> {
}
