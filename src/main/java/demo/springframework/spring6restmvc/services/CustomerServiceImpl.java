package demo.springframework.spring6restmvc.services;

import demo.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer cust1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Moon")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer cust2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Park")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer cust3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Hong")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap.put(cust1.getId(), cust1);
        customerMap.put(cust2.getId(), cust2);
        customerMap.put(cust3.getId(), cust3);
    }

    @Override
    public ArrayList<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerByID(UUID id) {
        return customerMap.get(id);
    }
}
