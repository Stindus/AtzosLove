package de.hsba.bi.webshop.atzos.paypal;


import de.hsba.bi.webshop.atzos.paypal.dao.Order;
import de.hsba.bi.webshop.atzos.paypal.dao.OrderRepository;
import de.hsba.bi.webshop.atzos.paypal.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/checkout")
@Slf4j
public class CheckoutController {

    private final PayPalHttpClient payPalHttpClient;
    private final OrderRepository orderDAO;

    @Autowired
    public CheckoutController(PayPalHttpClient payPalHttpClient, OrderRepository orderDAO) {
        this.orderDAO = orderDAO;
        this.payPalHttpClient = payPalHttpClient;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> checkout(@RequestBody OrderDTO orderDTO) throws Exception {
        var appContext = new PayPalAppContextDTO();
        appContext.setReturnUrl("http://localhost:8080/checkout/success");
        appContext.setBrandName("My brand");
        appContext.setLandingPage(PaymentLandingPage.BILLING);
        orderDTO.setApplicationContext(appContext);
        var orderResponse = payPalHttpClient.createOrder(orderDTO);

        var entity = new Order();
        entity.setPaypalOrderId(orderResponse.getId());
        entity.setPaypalOrderStatus(orderResponse.getStatus().toString());
        var out = orderDAO.save(entity);
        log.info("Saved order: {}", out);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping(value = "/success")
    public ResponseEntity<String> paymentSuccess(HttpServletRequest request) {
        var orderId = request.getParameter("token");
        var out = orderDAO.findByPaypalOrderId(orderId);
        out.setPaypalOrderStatus(OrderStatus.APPROVED.toString());
        orderDAO.save(out);
        return ResponseEntity.ok().body("Payment success");
    }

}
