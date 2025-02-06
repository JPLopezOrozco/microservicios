package com.juan.checkout.service.impl;

import com.juan.checkout.model.Checkout;
import com.juan.checkout.model.dto.Product;
import com.juan.checkout.service.ICheckoutService;
import com.juan.checkout.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService implements ICheckoutService{

    private IProductService productService;



    public CheckoutService(IProductService productService) {

        this.productService = productService;
    }

    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for(String id :  productIds){
            Product product = productService.getProduct(id);
            System.out.println("Respuesta desde"+product.getInstance());
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234","www.digitalhouse.com/checkout?code=234",total.toString(),List.of("credit_card"));


        return checkout;
    }




}