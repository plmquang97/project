package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.CustomerRequest;
import bookingticket.com.example.demo.entities.Customer;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.CustomerService;
import bookingticket.com.example.demo.service.dto.CustomerDto;
import bookingticket.com.example.demo.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(CustomerResource.PATH)
public class CustomerResource {
    public static final String PATH ="/api/customer";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>>getAll(){
        return ResponseEntity.ok(CustomerMapper.INSTANCE.toDtos(customerService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto>getCustomerById(@PathVariable(value="id")Integer id)throws ResourceNotFoundException{
        Customer customer = customerService.findCustomerById(id)
                .orElseThrow(()->new ResourceNotFoundException("Customer id not found :"+ id));
        return ResponseEntity.ok(CustomerMapper.INSTANCE.toDto(customer));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerRequest customerRequest){
        Customer createdCustomer = customerService.saveCustomer(customerRequest);
        return ResponseEntity
                .created(URI.create(CustomerResource.PATH + "/"+ createdCustomer.getCustomerId()))
                .body(CustomerMapper.INSTANCE.toDto(createdCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete (@PathVariable(value = "id")Integer id)throws ResourceNotFoundException{
        Customer customer = customerService.findCustomerById(id)
                .orElseThrow(()->new ResourceNotFoundException("Customer id not found : " + id));
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update (@PathVariable(value ="id")Integer id,
                                                @RequestBody CustomerRequest customerRequest) throws ResourceNotFoundException{
        return ResponseEntity.ok(customerMapper.toDto(customerService.update(id,customerRequest)));
    }
}
