package com.ohgiraffers.crud.customer.model.service;

import com.ohgiraffers.crud.customer.model.dao.CustomerMapper;
import com.ohgiraffers.crud.customer.model.dto.CustomerDTO;
import com.ohgiraffers.crud.customer.model.dto.spaceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> findAllCustomer() {
        return customerMapper.findAllCustomer();
    }

    @Transactional(readOnly = true)
    public List<spaceDTO> findCategoryList() {
        return customerMapper.findCategoryList();
    }

    @Transactional
    public void registCustomer(CustomerDTO customer) {
        customerMapper.registCustomer(customer);

    }

    public void deleteCustomer(Long customerCode) {
        customerMapper.deleteCustomer(customerCode);
    }
}
