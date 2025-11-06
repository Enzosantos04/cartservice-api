package enzosdev.cartservice.controller;


import enzosdev.cartservice.controller.request.CartRequest;
import enzosdev.cartservice.controller.request.PaymentRequest;
import enzosdev.cartservice.entity.Cart;
import enzosdev.cartservice.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.createCart(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable String id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody CartRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.updateCart(id, request));
    }

    @PutMapping("/{id}/payment")
    ResponseEntity<Cart> payCart(@PathVariable String id, @RequestBody PaymentRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.payCart(id, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCartById(@PathVariable String id) {
        cartService.deleteCartById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }

}
