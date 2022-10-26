package net.javaguides.sms.service;
import java.util.List;

import net.javaguides.sms.entity.Checkout;

public interface CheckoutService {


Checkout saveCheckout(Checkout checkout);

Checkout getCheckoutById(Long id);

Checkout updateCheckout(Checkout checkout);

void deleteCheckoutById(Long id);

List<Checkout> getAllCheckouts();
}
