package enzosdev.cartservice.controller.request;


import enzosdev.cartservice.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequest {
   private PaymentMethod paymentMethod;
}
