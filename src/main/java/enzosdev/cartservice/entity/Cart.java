package enzosdev.cartservice.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import enzosdev.cartservice.enums.PaymentMethod;
import enzosdev.cartservice.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "cart")
public class Cart {
    @Id
    private String id;
    private long client;
    private BigDecimal totalPrice;
    private List<Product> products;
    private Status status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaymentMethod paymentMethod;

    public void calculateTotalPrice(){
        this.totalPrice = products.stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
