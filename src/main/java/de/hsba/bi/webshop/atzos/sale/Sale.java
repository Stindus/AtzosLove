package de.hsba.bi.webshop.atzos.sale;

import de.hsba.bi.webshop.atzos.paypal.dao.Order;
import de.hsba.bi.webshop.atzos.product.Product;
import de.hsba.bi.webshop.atzos.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Diese Klasse stellt eine Transaktion bzw Rechnung für den Kauf eines Produktes dar.
@Entity
@NoArgsConstructor
@Table(name = "SALE")
public class Sale {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SALE_ID")
    private Long saleId;

    //Der Käufer des Produktes
    @ManyToOne
    @Getter
    @JoinColumn(name = "BUYER_ID")
    User buyer;

    //Das verkaufte Produkt
    @ManyToOne
    @Getter
    @JoinColumn(name = "SOLDPRODUCT_ID")
    Product soldProduct;

    @OneToOne
    @Getter
    @JoinColumn(name = "PAYPAL_ORDER")
    Order payPalOrder;

    //Anzahl der verkauften Einheiten
    @Getter
    @Setter
    @Column(name = "NUMBER_BOUGHT", nullable = false, unique = false)
    private Long numberBought;

    //Versandstatus der gekauften Produkte. Ist der Status false, ist das Produkt noch nicht versandt; Ist der Status true, wurde es versendet
    @Getter
    @Setter
    @Column(name = "ORDER_STATUS", nullable = false, unique = false)
    private boolean status;

    //Konstruktor
    public Sale (User buyer, Product product, Order payPalOrder, Long numberBought) {
        this.buyer = buyer;
        this.soldProduct = product;
        this.payPalOrder = payPalOrder;
        this.numberBought = numberBought;
        this.status = false;
    }

}
