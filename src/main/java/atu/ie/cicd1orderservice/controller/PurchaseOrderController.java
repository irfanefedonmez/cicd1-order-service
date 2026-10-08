package atu.ie.cicd1orderservice.controller;

import atu.ie.cicd1orderservice.model.PurchaseOrder;
import atu.ie.cicd1orderservice.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import atu.ie.cicd1orderservice.client.dto.ProductResponse;



import java.util.List;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }
    @GetMapping
    public List<PurchaseOrder> getALL() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }

    // Test the Catalog connection and return the product as a DTO.
    @GetMapping("/test-catalog/{productId}")
    public ProductResponse testCatalogConnection(
            @PathVariable Long productId) {

        return service.testCatalogConnection(productId);
    }


}
