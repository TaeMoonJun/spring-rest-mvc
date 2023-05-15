package demo.springframework.spring6restmvc.mappers;

import demo.springframework.spring6restmvc.entities.Customer;
import demo.springframework.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    Customer customerDtoTOCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
