package rs.radosacimovic.statsservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import rs.radosacimovic.statsservice.model.Product;

import java.util.List;

@FeignClient(name="product-service", url="http://product-service:8082")
public interface ProductClient {
    @GetMapping(value = "/api/products")
    List<Product> getProducts();
}
