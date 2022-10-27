package de.hsba.bi.webshop.atzos.product;

import de.hsba.bi.webshop.atzos.paypal.dao.Order;
import de.hsba.bi.webshop.atzos.paypal.dao.OrderRepository;
import de.hsba.bi.webshop.atzos.sale.Sale;
import de.hsba.bi.webshop.atzos.sale.SaleRepository;
import de.hsba.bi.webshop.atzos.user.User;
import de.hsba.bi.webshop.atzos.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//Klasse, die Testobjekte erzeugt, um die Funktion der Applikation zu testen
@Component
@RequiredArgsConstructor
public class TestDataCreator {

    //Abhängigkeiten
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final SaleRepository saleRepository;
    private final OrderRepository orderRepository;

    //Die Testobjekte sind auskommentiert, da es sonst mit persistenter Datenbank doppelte Datensätze gäbe
    @EventListener(ApplicationStartedEvent.class)
    public void init() {

        User atzosAdmin = userRepository.save(new User("Atzos Love","Atzos Love","$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO"));
        User testUser1 = userRepository.save(new User("Jakob","TestUser1","$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO"));

        Product testprodukt1 = productRepository.save(new Product("Hoodie", new BigDecimal(50), "Lockerer Fit", "Hoodies & Sweatshirts", "Schwarz", 100.0, 12.0, atzosAdmin));
        Product testprodukt2 = productRepository.save(new Product("T-Shirt", new BigDecimal(30), "T-Shirt mit Print", "T-Shirts", "Schwarz", 50.0, 0.0, atzosAdmin));
        Product testprodukt3 = productRepository.save(new Product("Jacke", new BigDecimal(100), "Bomberjacke", "Jacken", "Rot", 0.0, 5.0, atzosAdmin));

        Order testOrder1 = orderRepository.save(new Order());
        Order testOrder2 = orderRepository.save(new Order());

        Sale testSale1 = saleRepository.save(new Sale(testUser1, testprodukt1, testOrder1,1L));
        Sale testSale2 = saleRepository.save(new Sale(testUser1, testprodukt3, testOrder2, 2L));


        //weitere Testdaten zum CSS-testen
        /*Product testprodukt4 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt5 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt6 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt7 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt8 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt9 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt10 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt11 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt12 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt13 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt14 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt15 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt16 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt17 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt18 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt19 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt20 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt21 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt22 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt23 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt24 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
*/


    }
}
