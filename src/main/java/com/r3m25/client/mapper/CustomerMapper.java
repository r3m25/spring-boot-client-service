package com.r3m25.client.mapper;

import com.r3m25.client.client.domain.Address;
import com.r3m25.client.client.domain.User;
import com.r3m25.client.domain.Customer;
import com.r3m25.client.mapper.anotation.CustomerAddress;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = "spring",
        implementationName = "CustomerMapperImpl"
)
public interface CustomerMapper {

    @Mappings({
            @Mapping(target="address", source = "address" , qualifiedBy = CustomerAddress.class),
            @Mapping(target="company", source="user.company.name")
    })
    Customer userClientToCustomer(User user);

    List<Customer> userClientListToCustomerList(List<User> userList);

    @CustomerAddress
    static String buildCustomerAddress(Address address) {
        return address.getStreet().concat(", ").concat(address.getCity());
    }

}
