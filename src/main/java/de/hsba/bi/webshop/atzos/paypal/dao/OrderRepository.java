package de.hsba.bi.webshop.atzos.paypal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByPaypalOrderId(String paypalOrderId);


}
