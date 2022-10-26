package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Checkout;
import net.javaguides.sms.repository.CheckoutRepository;
import net.javaguides.sms.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService{

private CheckoutRepository checkoutRepository;

public CheckoutServiceImpl(CheckoutRepository checkoutRepository) {
super();
this.checkoutRepository = checkoutRepository;
}

@Override
public List<Checkout> getAllCheckouts() {
return checkoutRepository.findAll();
}

@Override
public Checkout saveCheckout(Checkout checkout) {
return checkoutRepository.save(checkout);
}

@Override
public Checkout getCheckoutById(Long id) {
return checkoutRepository.findById(id).get();
}

@Override
public Checkout updateCheckout(Checkout checkout) {
return checkoutRepository.save(checkout);
}

@Override
public void deleteCheckoutById(Long id) {
	checkoutRepository.deleteById(id);
}

}