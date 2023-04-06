package demo.springframework.spring6restmvc.services;

import demo.springframework.spring6restmvc.model.CustomerDTO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    ArrayList<CustomerDTO> listCustomers();

    Optional<CustomerDTO> getCustomerByID(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateCustomerById(UUID customerId, CustomerDTO customer);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customer);
}
