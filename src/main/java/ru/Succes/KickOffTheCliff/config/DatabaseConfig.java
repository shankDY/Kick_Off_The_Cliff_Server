package ru.Succes.KickOffTheCliff.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
/*мы будем использовать jpa (SpringData, кооторый постоенна патерне репозитер)(спецификация API Java EE,
предоставляет возможность сохранять в удобном виде Java-объекты в базе данных[1])*/
@EnableJpaRepositories("ru.Succes.KickOffTheCliff.repository")// вкл подержку jpa repository
/*транзакционность предоставляет возможность роубека( отката) определенных транзакций.
* Например, если мы сделали какие-то манипуляции с базой и она перестала отвечать.
* То произойдет откат на стороне бД. Тем самым она не будет хранить нецелостные данные*/
@EnableTransactionManagement
@PropertySource("classpath:db.properties")// указываем путь к проперти файлу( файл, хранящий все свойства бд)
@ComponentScan("ru.Succes.KickOffTheCliff") //рут пакет, где искать наши репозитории, конфиги и т.д
public class DatabaseConfig {

    @Resource
    private Environment env;//сможем получать доступ к нашим проперти файлам и получать значения
    private Properties hibernateProperties;


    /*кратко о том , что такое EntityManagerFactory. Есть такое понятие как Entity -сущность
     * Entity в нашем случае, это классы , которые отображают таблицы БД , как классы.( отображение нашей модели данных, которую мы будем писать на джава, в БД
      * EntityManagerFactory предоставляет возможность автоматического создания наших бинов и создания таблиц на основе наших бинов*/
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));// сканим те энтети , которыми будет управлять данный метод
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // говорим, что в качестве JPA провайдера будем использовать hibernate

        em.setJpaProperties(getHibernateProperties());//entityManager-у должны просетить

        return em;
    }


    /*все вот это делали чтобы инцилизировать Bean LocalContainerEntityManagerFactoryBean, названный в нашем случае entityManagerFactoryBean() ,
     который потребуется для работы с базой данных */
    @Bean //для инциализации бина
    /*Данный метод, связующее звено между БД и спрингворком springData, а точнее c jdbc driver-ом */
    public DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
         /*метод getRequiredProperty возвращает строковую переменную*/
        ds.setUrl(env.getRequiredProperty("db.url"));//получаем url
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));//говорим какой драйвер использовать
        ds.setUsername(env.getRequiredProperty("db.username"));//получаем username
        ds.setPassword(env.getRequiredProperty("db.password"));//получаем пороль


        /*конфигурируем наш dbcp*/
        ds.setInitialSize(Integer.valueOf(env.getRequiredProperty("db.initialSize")));
        ds.setMinIdle(Integer.valueOf(env.getRequiredProperty("db.mineIdle")));
        ds.setMaxIdle(Integer.valueOf(env.getRequiredProperty("db.maxIdle")));
        ds.setTimeBetweenEvictionRunsMillis(Integer.valueOf(env.getRequiredProperty("db.timeBetweenEvictionRunsMillis")));
        ds.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("db.mineEvictableIdleTimeMillis")));
        ds.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("db.testOnBorrow")));
        ds.setValidationQuery(env.getRequiredProperty("db.validationQuery"));

        return  ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){//нейминг спринга и его так и надо называть
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());

        return manager;
    }

    public Properties getHibernateProperties() {
        try {


            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties"); // подгружаем сразу весь файл с property
            properties.load(is);
            return properties;
        }
        catch (IOException e ){
            throw new IllegalArgumentException("Can't find 'hibernate.properties' in classpath!",e); // не могу найти проперти файл
        }
    }
}



/*conectionPool это возможность проекта своевременно и наперед создавать готовые конекшины, чтобы выдавать их пользователям, сессиям для работы с бд
* Database Connection Pool (dbcp) — это способ решения изложенной выше проблемы. Он подразумевает,
* что в нашем распоряжении имеется некоторый набор («пул») соединений к базе данных.
* Когда новый пользователь запрашивает доступ к БД, ему выдаётся уже открытое соединение из этого пула. Если все открытые соединения уже заняты, создаётся новое.
* Как только пользователь освобождает одно из уже существующих соединений, оно становится доступно для других пользователей. Если соединение долго не используется, оно закрывается.*/