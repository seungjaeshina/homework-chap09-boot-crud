package com.ohgiraffers.crud.customer.controller;

import com.ohgiraffers.crud.configuration.HomeworkChap09BootCrudApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes = {HomeworkChap09BootCrudApplication.class})
public class CustomerControllerTests {

    @Autowired
    private CustomerController customerController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void 전체_고객_조회_컨트롤러_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("customer/list"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @Transactional
    public void 신규_고객_등록_컨트롤러_테스트() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("customerName","컨트롤러테스트");
        params.add("customerGender", "F");
        params.add("customerAge", "19");
        params.add("CategoryNo", "3");
        params.add("RoomCode", "25");

        mockMvc.perform(MockMvcRequestBuilders.post("/customer/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/customer/list"))
                .andDo(MockMvcResultHandlers.print());
    }
}
