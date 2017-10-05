package ru.Succes.KickOffTheCliff.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*для одной сущности один репозиторий */
@Entity
@Table(name = "winter")// имя нашей бд
public class EntityOfWinter {

    /*то что мы будем передавать в наше приложение*/
    @Id
    /*указываем , чтобы наше поле id автоинкрементилось(Суррога́тный ключ — понятие теории реляционных баз данных.
Это дополнительное служебное поле, добавленное к уже имеющимся информационным полям таблицы, единственное предназначение которого — служить первичным ключом.
Значение этого поля не образуется на основе каких-либо других данных из БД, а генерируется искусственно.)*/
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long winter_id;

    // название колонки нашей бд, второе свойство означает, что данные колонки не должны быть пустыми, третие поле -сколько символов может включать данная колонка
    @Column(name = "title",nullable = false,length = 50)
    private String winter_title;

    @Column(name = "info",nullable = false,length = 1000)
    private String winter_info;

    @Column(name = "photo",length = 500)
    private String winter_photo;

    /*конструктор пустой*/
    public EntityOfWinter() {
    }

    /*getter and setter*/
    public long getWinter_id() {
        return winter_id;
    }

    public void setWinter_id(long winter_id) {
        this.winter_id = winter_id;
    }

    public String getWinter_title() {
        return winter_title;
    }

    public void setWinter_title(String winter_title) {
        this.winter_title = winter_title;
    }

    public String getWinter_info(){return winter_info;}

    public  void setWinter_info(String winter_info){this.winter_info =winter_info;}

    public String getWinter_photo(){return winter_photo;}

    public  void setWinter_photo(String winter_photo){this.winter_photo =winter_photo;}
}
