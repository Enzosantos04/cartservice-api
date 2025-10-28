package enzosdev.cartservice.client;

import java.io.Serializable;
import java.math.BigDecimal;

public record DummyProductResponse(Long id, String title, BigDecimal price) implements Serializable {
}
