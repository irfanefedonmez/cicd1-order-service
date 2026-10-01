package atu.ie.cicd1orderservice.service;

import atu.ie.cicd1orderservice.model.PurchaseOrder;
import atu.ie.cicd1orderservice.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }
    public List<PurchaseOrder> getAll() {
       return this.repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return this.repository.save(order);
    }
}
