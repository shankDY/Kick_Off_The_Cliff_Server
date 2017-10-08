package ru.Succes.KickOffTheCliff.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "coordinatesSummer")
public class CoordinatesSummer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "coordinates_ID",nullable = false)
    private EntityOfSummer coordinates_ID ;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;


    /*конструктор пустой*/
    public CoordinatesSummer() {
    }

    /*getter and setter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCoordinates_ID() {
        return coordinates_ID.getId();
    }

    public void setCoordinates_ID(EntityOfSummer coordinates_ID) {
        this.coordinates_ID = coordinates_ID;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }




}
