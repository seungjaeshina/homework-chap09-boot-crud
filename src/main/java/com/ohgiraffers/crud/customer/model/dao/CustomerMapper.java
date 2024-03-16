package com.ohgiraffers.crud.customer.model.dao;

import com.ohgiraffers.crud.customer.model.dto.CustomerDTO;
import com.ohgiraffers.crud.customer.model.dto.spaceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<CustomerDTO> findAllCustomer();

    List<spaceDTO> findCategoryList();

    void registCustomer(CustomerDTO customer);

    void deleteCustomer(Long customerList);
}
