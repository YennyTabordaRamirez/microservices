package microservice.store2.serviceShopping2.client;

import microservice.store2.serviceShopping2.model.ProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
@RequestMapping(value = "/products")
public interface IProductClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable("id") Long id);

    @GetMapping(value = "/{id}/stock")
    public  ResponseEntity<ProductModel> updateStockProduct
            (@PathVariable("id")Long id,
             @RequestParam(name="quantity", required = true) Double quantity);
}
