package ru.Succes.KickOffTheCliff.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*для одной сущности один репозиторий */
@Entity
@Table(name = "summer")// имя нашей бд
public class EntityOfSummer {

    /*то что мы будем передавать в наше приложение*/
    @Id
    /*указываем , чтобы наше поле id автоинкрементилось(Суррога́тный ключ — понятие теории реляционных баз данных.
Это дополнительное служебное поле, добавленное к уже имеющимся информационным полям таблицы, единственное предназначение которого — служить первичным ключом.
Значение этого поля не образуется на основе каких-либо других данных из БД, а генерируется искусственно.)*/
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    // название колонки нашей бд, второе свойство означает, что данные колонки не должны быть пустыми, третие поле -сколько символов может включать данная колонка
    @Column(name = "title",nullable = false,length = 50)
    private String title;

    @Column(name = "info",nullable = false,length = 1000)
    private String info;

    @Column(name = "photo",length = 500)
    private String photo;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    /*конструктор пустой*/
    public EntityOfSummer() {
    }

    /*getter and setter*/
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo(){return info;}
    public  void setInfo(String info){this.info =info;}

    public String getPhoto(){return photo;}
    public  void setPhoto(String photo){this.photo =photo;}

    public double getLongitude(){return longitude;}
    public void setLongitude(double longitude){this.longitude = longitude;}

    public double getLatitude(){return latitude;}
    public void setLatitude(double latitude){this.latitude = latitude;}
}
