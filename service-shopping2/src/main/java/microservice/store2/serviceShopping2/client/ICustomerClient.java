package microservice.store2.serviceShopping2.client;

import microservice.store2.serviceShopping2.model.CustomerModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer-service")
@RequestMapping(value = "/customers")
public interface ICustomerClient {

    @GetMapping(value= "/{id}")
    public ResponseEntity<CustomerModel> getCustomers(@PathVariable("id") Long id);

}
