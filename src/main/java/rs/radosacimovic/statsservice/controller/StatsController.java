package rs.radosacimovic.statsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.radosacimovic.statsservice.model.Product;
import rs.radosacimovic.statsservice.model.User;
import rs.radosacimovic.statsservice.service.StatsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/best-seller")
    public ResponseEntity<User> getBestSeller() {
        return ResponseEntity.ok(statsService.getBestOrWorstSeller(true));
    }

    @GetMapping("/worst-seller")
    public ResponseEntity<User> getWorstSeller() {
        return ResponseEntity.ok(statsService.getBestOrWorstSeller(false));
    }

    @GetMapping("/most-expensive-product")
    public ResponseEntity<Product> getMostExpensiveProduct() {
        return ResponseEntity.ok(statsService.getMostExpensiveProduct());
    }

    @GetMapping("/cheapest-product")
    public ResponseEntity<Product> getCheapestProduct() {
        return ResponseEntity.ok(statsService.getCheapestProduct());
    }

    @GetMapping("/percentage-of-sold-products")
    public ResponseEntity<Double> getPercentageOfSoldProducts() {
        return ResponseEntity.ok(statsService.getPercentageOfSoldProducts());
    }
}
