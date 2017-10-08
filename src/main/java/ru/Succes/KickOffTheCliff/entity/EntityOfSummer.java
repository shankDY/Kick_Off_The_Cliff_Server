package ru.Succes.KickOffTheCliff.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /*конструктор пустой*/
    public EntityOfSummer() {
    }


   @OneToMany(mappedBy = "coordinates_ID")
   private Set<CoordinatesSummer> coordinatesSummers =  new HashSet<CoordinatesSummer>();

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


}
