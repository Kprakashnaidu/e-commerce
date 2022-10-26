package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Checkout;


public interface CheckoutRepository extends JpaRepository<Checkout, Long>{

}