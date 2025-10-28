package enzosdev.cartservice.controller;

import enzosdev.cartservice.client.DummyProductResponse;
import enzosdev.cartservice.client.ProductListResponse;
import enzosdev.cartservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<DummyProductResponse>> getAllProducts(){
        ProductListResponse products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products.products());
    }


    @GetMapping("/{id}")
    public ResponseEntity<DummyProductResponse> getAllProductById(@PathVariable Long id){
        DummyProductResponse products = productService.getAllProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
