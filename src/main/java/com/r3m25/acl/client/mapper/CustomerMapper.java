package com.r3m25.acl.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = "spring",
        implementationName = "CustomerMapperImpl"
)
public interface CustomerMapper {

}
