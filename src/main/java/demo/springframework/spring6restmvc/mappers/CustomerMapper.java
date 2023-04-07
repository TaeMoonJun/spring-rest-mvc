package demo.springframework.spring6restmvc.mappers;

import demo.springframework.spring6restmvc.entities.Customer;
import demo.springframework.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoTOCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
