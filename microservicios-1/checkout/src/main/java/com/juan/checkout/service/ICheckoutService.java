package com.juan.checkout.service;

import com.juan.checkout.model.Checkout;

import java.util.List;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productIds);
}
