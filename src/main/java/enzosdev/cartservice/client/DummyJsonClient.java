package enzosdev.cartservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "dummy", url = "${cart.client.dummy}")
public interface DummyJsonClient {
    @GetMapping("/products")
      ProductListResponse getAllProducts();

    @GetMapping("/products/{id}")
    DummyProductResponse getProductById(@PathVariable Long id);
}
