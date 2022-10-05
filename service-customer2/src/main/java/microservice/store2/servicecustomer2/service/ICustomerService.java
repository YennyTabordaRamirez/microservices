package microservice.store2.servicecustomer2.service;


import microservice.store2.servicecustomer2.entity.Customer;
import microservice.store2.servicecustomer2.entity.Region;

import java.util.List;

public interface ICustomerService {

    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public Customer getCustomerById(Long id);
}
