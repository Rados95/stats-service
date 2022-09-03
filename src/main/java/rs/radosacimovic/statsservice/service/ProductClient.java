package rs.radosacimovic.statsservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import rs.radosacimovic.statsservice.model.Product;

import java.util.List;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping(value = "/api/products")
    List<Product> getProducts();
}
