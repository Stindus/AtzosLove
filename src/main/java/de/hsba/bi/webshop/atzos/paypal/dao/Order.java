package de.hsba.bi.webshop.atzos.paypal.dao;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ORDER")
@Data
public class Order {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PALPAL_ORDER_ID")
    private String paypalOrderId;
    @Column(name = "PAYPAL_ORDER_STATUS")
    private String paypalOrderStatus;

    public Order(){
        this.paypalOrderId = paypalOrderId;
        this.paypalOrderStatus = paypalOrderStatus;
    }
}
