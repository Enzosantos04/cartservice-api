package enzosdev.cartservice;

import jdk.jshell.Snippet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface repository extends MongoRepository<Cart, String> {
    Optional<Cart> findByClientAndStatus(Long client, )
}
