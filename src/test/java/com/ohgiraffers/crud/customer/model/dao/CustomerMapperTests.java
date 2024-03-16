package com.ohgiraffers.crud.customer.model.dao;


import com.ohgiraffers.crud.configuration.HomeworkChap09BootCrudApplication;
import com.ohgiraffers.crud.customer.model.dto.CustomerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ContextConfiguration(classes ={HomeworkChap09BootCrudApplication.class})
public class CustomerMapperTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void 매퍼_인터페이스_의존성_주입_테스트(){
        assertNotNull(customerMapper);
    }

    @Test
    public void 전체_고객_조회_메퍼_테스트(){
        List<CustomerDTO> customerList = customerMapper.findAllCustomer();

        assertNotNull(customerList);
    }

    @Test
    @DisplayName("신규 고객 추가용 메퍼 인터페이스 메소드 확인")
    public void testRegistMenu(){
        CustomerDTO customer = new CustomerDTO();
        customer.setCustomerName("김훈");
        customer.setCustomerGender("M");
        customer.setCustomerAge(28);
        customer.setCategoryNo(1);
        customer.setRoomCode(5);

        assertDoesNotThrow(()-> customerMapper.registCustomer(customer));

    }

    @Test
    @DisplayName("신규 고객 추가 실패 테스트")
    @Transactional
    public void testRegistFaleMenu(){
        CustomerDTO customer = new CustomerDTO();
        customer.setCustomerName("실패");
        customer.setCustomerGender("F");
        customer.setCustomerAge(5);
        customer.setCategoryNo(100);
        customer.setRoomCode(0);


        assertThrows(Exception.class, () -> customerMapper.registCustomer(customer));
    }


}

