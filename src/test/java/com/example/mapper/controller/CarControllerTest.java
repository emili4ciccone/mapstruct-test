package com.example.mapper.controller;

import com.example.mapper.config.ControllerTestSliceConfiguration;
import com.example.mapper.data.bean.Car;
import com.example.mapper.mapper.CarDtoToBeanMapperImpl;
import com.example.mapper.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
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
@ContextConfiguration(classes = {ControllerTestSliceConfiguration.class, CarController.class})
class CarControllerTest {

    private MockMvc mockMvc;
    private final MultiValueMap<String, String> paramsHeader = new LinkedMultiValueMap<>();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CarService carServiceMock;

    @MockBean
    private CarDtoToBeanMapperImpl carDtoToBeanMapper;

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
