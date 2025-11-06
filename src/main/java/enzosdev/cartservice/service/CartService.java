package enzosdev.cartservice.service;


import enzosdev.cartservice.client.DummyProductResponse;
import enzosdev.cartservice.controller.request.CartRequest;
import enzosdev.cartservice.controller.request.PaymentRequest;
import enzosdev.cartservice.entity.Cart;
import enzosdev.cartservice.entity.Product;
import enzosdev.cartservice.enums.Status;
import enzosdev.cartservice.exceptions.BusinessException;
import enzosdev.cartservice.exceptions.DataNotFoundException;
import enzosdev.cartservice.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;


    public CartService(CartRepository cartRepository, ProductService productService){
        this.cartRepository = cartRepository;
        this.productService = productService;
    }




    public Cart createCart(CartRequest cartRequest){
        cartRepository.findByClientAndStatus(cartRequest.clientId(), Status.OPEN)
                .ifPresent(cart -> {
                   throw new BusinessException("There is already an open basket for this client");
                });

        List<Product> products = getProducts(cartRequest);

        Cart cart = Cart.builder()
                .client(cartRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();
        cart.calculateTotalPrice();
        return cartRepository.save(cart);


    }

    public Cart getCartById(String id){
        return cartRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Cart not found"));
    }

    public Cart updateCart(String cartId, CartRequest cartRequest){
        Cart savedCart =  getCartById(cartId);
        List<Product> products = getProducts(cartRequest);
        savedCart.setProducts(products);
        savedCart.calculateTotalPrice();
        return cartRepository.save(savedCart);
    }

    public Cart payCart(String cartId, PaymentRequest request){
        Cart savedCart = getCartById(cartId);
        savedCart.setPaymentMethod(request.getPaymentMethod());
        savedCart.setStatus(Status.SOLD);
        return cartRepository.save(savedCart);
    }


    public void deleteCartById(String cartId){
        Cart savedCart = getCartById(cartId);
        cartRepository.delete(savedCart);
    }


    private List<Product> getProducts(CartRequest cartRequest){
        List<Product> products = new ArrayList<>();
        cartRequest.products().forEach(productRequest ->{
            DummyProductResponse dummyProductResponse = productService.getAllProductById(productRequest.id());
            products.add(Product.builder()
                    .id(dummyProductResponse.id())
                    .title(dummyProductResponse.title())
                    .price(dummyProductResponse.price())
                    .quantity(productRequest.quantity())
                    .build());
        } );
        return products;
    }
}
