package com.ohgiraffers.crud.customer.controller;

import com.ohgiraffers.crud.customer.model.dto.CustomerDTO;
import com.ohgiraffers.crud.customer.model.dto.spaceDTO;
import com.ohgiraffers.crud.customer.model.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    private final MessageSource messageSource;

    public CustomerController(CustomerService customerService, MessageSource messageSource){
        this.customerService = customerService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String findCustomerList(Model model){

        List<CustomerDTO> customerList = customerService.findAllCustomer();

        model.addAttribute("customerList", customerList);

        return "customer/list";
    }

    @GetMapping("/regist")
    public void registPage(){}


    @GetMapping("/category")
    public @ResponseBody List<spaceDTO> findCategoryList(){

        return customerService.findCategoryList();
    }
    @PostMapping("/regist")
    public String registCustomer(@ModelAttribute CustomerDTO customer, RedirectAttributes rttr, Locale locale){

        logger.trace("customer : {} ",customer);
        logger.debug("customer : {} ",customer);
        logger.info("customer : {} ",customer);
        logger.warn("customer : {} ",customer);
        logger.error("customer : {} ",customer);

        customerService.registCustomer(customer);

        rttr.addFlashAttribute("successMessage",messageSource.getMessage("registMenu", null,locale));
        return "redirect:/customer/list";
    }
    @GetMapping("/delete")
    public String deleteCustomerForm() {
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("customerCode") Long customerCode, RedirectAttributes rttr, Locale locale) {
        logger.info("delete Customer with Code: {}", customerCode);
        customerService.deleteCustomer(customerCode);
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteCustomer", null, locale));
        return "redirect:/customer/list";
    }
    }
