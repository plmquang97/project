package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.api.request.CustomerRequest;
import bookingticket.com.example.demo.entities.Customer;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.repositories.CustomerRepository;
import bookingticket.com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customerRequest.getCustomerName());
        newCustomer.setEmail(customerRequest.getEmail());
        newCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
        newCustomer.setBirthDay(customerRequest.getBirthDay());
        return customerRepository.save(newCustomer);
    }

    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Integer id, CustomerRequest customerRequest) throws ResourceNotFoundException {
        Customer editCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer id not found : " + id));
        editCustomer.setCustomerName(customerRequest.getCustomerName());
        editCustomer.setEmail(customerRequest.getEmail());
        editCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
        editCustomer.setBirthDay(customerRequest.getBirthDay());
        return customerRepository.save(editCustomer);
    }
}
