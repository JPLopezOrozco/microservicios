package com.juan.checkout.controller;

import com.juan.checkout.model.Checkout;
import com.juan.checkout.service.ICheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private ICheckoutService checkoutService;



    @Autowired
    public CheckoutController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }



    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader() Map<String,String> headers) {

        System.out.println("Enviado desde ");
        return checkoutService.buildCheckout(productIds);

    }

    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id){
        return new Checkout(id);
    }

}
