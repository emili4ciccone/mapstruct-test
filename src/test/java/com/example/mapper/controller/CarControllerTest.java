package com.example.mapper.controller;

import com.example.mapper.config.MapperSpringConfig;
import com.example.mapper.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.extensions.spring.converter.ConverterScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CarController.class})
class CarControllerTest {

    @Configuration
    @ComponentScan("org.mapstruct.extensions.spring")
    @ComponentScan("com.example.mapper.mapper")
    @ConverterScan(basePackageClasses = MapperSpringConfig.class)
    static class AdditionalBeanConfiguration {
        @Bean
        ConfigurableConversionService myConversionService() {
            return new DefaultConversionService();
        }
    }

    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService myConversionService;

    private MockMvc mockMvc;
    private final MultiValueMap<String, String> paramsHeader = new LinkedMultiValueMap<>();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CarService carServiceMock;

    @BeforeEach
    void init() {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String toDay = df.format(new Date());

        paramsHeader.add("RequestID", "fdsfdsaer77909fds");
        paramsHeader.add("RequestDate", toDay);
        paramsHeader.add("UserID", "1000");
        paramsHeader.add("OriginalRequestDate", toDay);
        paramsHeader.add("ImpersonatedUserID", "1100");

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void getCar() throws Exception {

        // When
        mockMvc.perform(get("/car")
                        .headers(new HttpHeaders(paramsHeader)))
                .andDo(print())
                // Then
                .andExpect(status().isOk());

    }



}
