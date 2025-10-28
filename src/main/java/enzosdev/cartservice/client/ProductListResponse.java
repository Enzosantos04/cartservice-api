package enzosdev.cartservice.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductListResponse(List<DummyProductResponse> products) implements Serializable {
}
