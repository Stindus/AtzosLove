package de.hsba.bi.webshop.atzos.paypal;

import de.hsba.bi.webshop.atzos.paypal.dao.Order;
import de.hsba.bi.webshop.atzos.paypal.dao.OrderRepository;
import de.hsba.bi.webshop.atzos.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order findOrderById(Long id){
        if(orderRepository.findById(id).isPresent()) return orderRepository.findById(id).get();
        else return null;
    }

}
