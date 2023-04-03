package demo.springframework.spring6restmvc.services;

import demo.springframework.spring6restmvc.model.Customer;

import java.util.ArrayList;
import java.util.UUID;

public interface CustomerService {
    ArrayList<Customer> listCustomers();

    Customer getCustomerByID(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);
}
