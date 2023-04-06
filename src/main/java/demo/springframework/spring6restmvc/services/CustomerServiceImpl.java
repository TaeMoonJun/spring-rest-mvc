package demo.springframework.spring6restmvc.services;

import demo.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

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
    public Optional<Customer> getCustomerByID(UUID id) {
        return Optional.of(customerMap.get(id));
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer savedCustomer =  Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        Customer existing = customerMap.get(customerId);
        existing.setCustomerName(customer.getCustomerName());

        customerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {
        Customer existing = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getCustomerName())) {
            existing.setCustomerName(customer.getCustomerName());
        }

        customerMap.put(existing.getId(), existing);
    }
}
