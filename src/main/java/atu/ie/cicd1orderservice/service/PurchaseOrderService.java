package atu.ie.cicd1orderservice.service;

import atu.ie.cicd1orderservice.model.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService {
    private final List<PurchaseOrder> orders = new ArrayList<>();
    private long nextID = 1;

    public List<PurchaseOrder> getAll() {
        return orders;
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(nextID++);
        orders.add(order);
        return order;
    }
}
