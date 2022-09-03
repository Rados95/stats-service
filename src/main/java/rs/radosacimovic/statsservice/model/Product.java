package rs.radosacimovic.statsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String code;
    private String name;
    private String productType;
    private BigDecimal price;
    private String seller;
    private Boolean sold;
}
