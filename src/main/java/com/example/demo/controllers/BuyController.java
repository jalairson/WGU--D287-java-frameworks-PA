package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyController {

    @Autowired
        private ApplicationContext context;

        private static Product product1;

        @GetMapping("/buynow")
        public ModelAndView buynow(@RequestParam("productID") int theId) {

        ProductService repo = context.getBean(ProductServiceImpl.class);
        Product theProduct = repo.findById(theId);
        product1=theProduct;

        if(product1.getInv() == 0) {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("purchasefailed.html");
                return modelAndView;
        }
        else {
            product1.setInv(product1.getInv() - 1);
            repo.save(product1);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchasesuccessful.html");
            return modelAndView;
        }
    }

}