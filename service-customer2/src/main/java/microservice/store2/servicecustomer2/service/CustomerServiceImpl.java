package microservice.store2.servicecustomer2.service;

import lombok.extern.slf4j.Slf4j;
import microservice.store2.servicecustomer2.entity.Customer;
import microservice.store2.servicecustomer2.entity.Region;
import microservice.store2.servicecustomer2.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomersByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDb = customerRepository.findByNumberID(customer.getNumberID());
        if(null != customerDb){
            return customerDb;
        }
        customer.setState("CREATED");
        customerDb = customerRepository.save(customer);
        return customerDb;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDb = getCustomerById(customer.getId());
        if(customerDb == null){
            return null;
        }
        customerDb.setFirstName(customer.getFirstName());
        customerDb.setLastName(customer.getLastName());
        customerDb.setEmail(customer.getEmail());
        customerDb.setPhotoUrl(customer.getPhotoUrl());

        return customerRepository.save(customerDb);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDb = customerRepository.findByNumberID(customer.getNumberID());
        if(customerDb == null){
            return null;
        }
        customer.setState("Deleted");
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
