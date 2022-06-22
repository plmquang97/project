package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.api.request.CustomerRequest;
import bookingticket.com.example.demo.entities.Customer;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();

    Customer saveCustomer(CustomerRequest customer);

    Optional<Customer> findCustomerById(Integer id);

    void deleteCustomerById(Integer id);

    Customer update(Integer id, CustomerRequest customerRequest) throws ResourceNotFoundException;
}
