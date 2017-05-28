package ru.Succes.KickOffTheCliff.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;
import java.util.List;

@Configuration// анатация говорит о том , что данный класс является конфиигурацией, которую нужно выполнить перед тем , как разворачивать контекст спринга
@EnableWebMvc// данная анатция говорит, что мы должны вкл режим веб mvc
@ComponentScan("ru.Succes.KickOffTheCliff")// где искать наши бины( классы, сервисы ,компоненты, репозитории
public class WebConfig extends WebMvcConfigurerAdapter {

    /*преобразуем наши запросы в json запросы */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON)); // передается List

        converters.add(converter); // добавляем в конвертер метода , наш созданный конвертер

    }
}
