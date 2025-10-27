package enzosdev.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableCaching
public class CartserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartserviceApplication.class, args);
    }

}
