
package atu.ie.cicd1orderservice.service;

import atu.ie.cicd1orderservice.client.CatalogClient;
import atu.ie.cicd1orderservice.client.dto.ProductResponse;
import atu.ie.cicd1orderservice.model.PurchaseOrder;
import atu.ie.cicd1orderservice.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;
    private final CatalogClient catalogClient;

    public PurchaseOrderService(
            PurchaseOrderRepository repository,
            CatalogClient catalogClient) {
        this.repository = repository;
        this.catalogClient = catalogClient;
    }

    // Get all orders from the database.
    public List<PurchaseOrder> getAll() {
        return this.repository.findAll();
    }

    // Create a new order and save it to the database.
    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return this.repository.save(order);
    }

    // Retrieve product information from Catalog Service as a DTO.
    public ProductResponse testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
}
