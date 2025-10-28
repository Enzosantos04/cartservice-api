package enzosdev.cartservice.repository;

import enzosdev.cartservice.entity.Cart;
import enzosdev.cartservice.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByClientAndStatus(Long client, Status status);
}
