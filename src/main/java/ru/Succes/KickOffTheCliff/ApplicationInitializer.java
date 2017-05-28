package ru.Succes.KickOffTheCliff;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.Succes.KickOffTheCliff.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 *данный класс будет инцилизировать наш спринг контекст( сервлет контекст). Разворачивать, создавать.
 */
public class ApplicationInitializer implements WebApplicationInitializer{

    private final static String DISPATCHER = "dispatcher"; // имя на основани которого будет зареган диспечер



    /*данный метод говрит, что мы хотим выполнить какие-то действия, перед тем , как будет расворачиваться наш контекст*/
    public void onStartup(ServletContext servletContext) throws ServletException {

        //контекст, который мы зарегаем в наш сервлет
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        //в диспечер сервлет добавляем наш сервлет контекст
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER,new DispatcherServlet(ctx));
        servlet.addMapping("/"); // показывает по какому контексту будет доступно наше приложение
        servlet.setLoadOnStartup(1);//если мы будем мапить несколько сервлетов, мы кажем в каком порядке они должны быть инциализированы
    }
}