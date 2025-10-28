package enzosdev.cartservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Builder
@Getter
public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
