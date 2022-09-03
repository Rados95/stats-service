package rs.radosacimovic.statsservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.radosacimovic.statsservice.model.Product;
import rs.radosacimovic.statsservice.model.User;

import java.text.DecimalFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final UserClient userClient;
    private final ProductClient productClient;

    public User getBestOrWorstSeller(boolean best) {
        List<User> users = userClient.getSellers();
        List<Product> product = productClient.getProducts();
        Map<String, Long> numberOfSoldProductsPerUser = new HashMap<>();
        for (User user : users
        ) {
            numberOfSoldProductsPerUser.put(user.getUsername(),
                    product.stream().filter(p -> user.getUsername().equals(p.getSeller())).count());
        }
        String username = best ? Collections.max(
                        numberOfSoldProductsPerUser.entrySet(),
                        Comparator.comparingLong(Map.Entry::getValue))
                .getKey() : Collections.min(
                        numberOfSoldProductsPerUser.entrySet(),
                        Comparator.comparingLong(Map.Entry::getValue))
                .getKey();
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElseThrow();
    }

    public Product getMostExpensiveProduct() {
        List<Product> allProducts = productClient.getProducts();
        allProducts.sort(Comparator.comparing(Product::getPrice));
        return allProducts.get(allProducts.size() - 1);
    }

    public Product getCheapestProduct() {
        List<Product> allProducts = productClient.getProducts();
        allProducts.sort(Comparator.comparing(Product::getPrice));
        return allProducts.get(0);
    }

    public double getPercentageOfSoldProducts() {
        List<Product> allProducts = productClient.getProducts();
        long numOfSoldProducts = allProducts.stream().filter(Product::getSold).count();
        DecimalFormat df = new DecimalFormat("##.##");
        return Double.parseDouble(df.format(((double) numOfSoldProducts / (double) allProducts.size()) * 100));
    }
}
