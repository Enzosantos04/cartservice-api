package enzosdev.cartservice.service;


import enzosdev.cartservice.client.DummyJsonClient;
import enzosdev.cartservice.client.DummyProductResponse;
import enzosdev.cartservice.client.ProductListResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final DummyJsonClient dummyJsonClient;

    public ProductService(DummyJsonClient dummyJsonClient){
        this.dummyJsonClient = dummyJsonClient;
    }


    @Cacheable(value = "products")
    public ProductListResponse getAllProducts(){
        return dummyJsonClient.getAllProducts();
    }

    @Cacheable(value = "products", key = "#productId")
        public DummyProductResponse getAllProductById(Long productId){
        return dummyJsonClient.getProductById(productId);
    }


}
