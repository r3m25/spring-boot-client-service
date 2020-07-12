package com.r3m25.client.mapper;

import com.r3m25.client.client.domain.Address;
import com.r3m25.client.client.domain.Company;
import com.r3m25.client.client.domain.User;
import com.r3m25.client.domain.Customer;
import com.r3m25.client.mapper.anotation.CustomerAddress;
import com.r3m25.client.mapper.anotation.CustomerCompanyName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = "spring",
        implementationName = "CustomerMapperImpl"
)
public interface CustomerMapper {

    @Mappings({
            @Mapping(target="address", source = "address" , qualifiedBy = CustomerAddress.class),
            @Mapping(target="company", source="user.company", qualifiedBy = CustomerCompanyName.class),
            @Mapping(target="customerId", source="user.id")
    })
    Customer userClientToCustomer(User user);

    @CustomerCompanyName
    static String userCompanyName(Company company) {
        return company.getName();
    }

    @CustomerAddress
    static String buildCustomerAddress(Address address) {
        return address.getStreet().concat(", ").concat(address.getCity());
    }

}
