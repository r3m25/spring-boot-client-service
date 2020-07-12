package com.r3m25.client.utilts;

import com.r3m25.client.client.domain.Address;
import com.r3m25.client.client.domain.Company;
import com.r3m25.client.client.domain.User;
import com.r3m25.client.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertUtils {

    private AssertUtils() {
    }

    /**
     * Compare data between customer and user.
     * @param customer data.
     * @param user data.
     */
    public static void assertDataCustomerWithDataUser(Customer customer, User user) {
        assertNotNull(customer);
        assertNotNull(user);
        assertNotNull(user.getId());

        assertEquals(customer.getCustomerId(), String.valueOf(user.getId()));
        assertEquals(customer.getUsername(), user.getUsername());
        assertEquals(customer.getWebsite(), user.getWebsite());
        assertEquals(customer.getPhone(), user.getPhone());
        assertEquals(customer.getName(), user.getName());
        assertEquals(customer.getEmail(), user.getEmail());

        assertNotNullAddress(user.getAddress());
        Address address = user.getAddress();
        assertEquals(customer.getAddress(), address.getStreet().concat(", ").concat(address.getCity()));

        assertNotNullCompany(user.getCompany());
        assertEquals(customer.getCompany(), user.getCompany().getName());
    }

    /**
     * Compare user expected with user actually.
     * @param userExpected
     * @param userActually
     */
    public static void assertExpectedUser(User userExpected, User userActually) {
        assertNotNull(userExpected);
        assertNotNull(userActually);
        assertNotNullAddress(userExpected.getAddress());
        assertNotNullAddress(userActually.getAddress());
        assertNotNullCompany(userExpected.getCompany());
        assertNotNullCompany(userActually.getCompany());

        assertEquals(userExpected.getId(), userActually.getId());
        assertEquals(userExpected.getName(), userActually.getName());
        assertEquals(userExpected.getPhone(), userActually.getPhone());
        assertEquals(userExpected.getUsername(), userActually.getUsername());
        assertEquals(userExpected.getWebsite(), userActually.getWebsite());
        assertEquals(userExpected.getEmail(), userActually.getEmail());

        Address addressExpected = userExpected.getAddress();
        Address addressActually = userActually.getAddress();

        assertEquals(addressExpected.getCity(), addressActually.getCity());
        assertEquals(addressExpected.getStreet(), addressActually.getStreet());
        assertEquals(addressExpected.getSuite(), addressActually.getSuite());
        assertEquals(addressExpected.getZipcode(), addressActually.getZipcode());

        Company companyExpected = userExpected.getCompany();
        Company companyActually = userActually.getCompany();

        assertEquals(companyExpected.getName(), companyActually.getName());
        assertEquals(companyExpected.getBs(), companyActually.getBs());
        assertEquals(companyExpected.getCatchPhrase(), companyActually.getCatchPhrase());
    }

    /**
     *
     */
    public static void  assertExpectedCustomer(Customer expectedCustomer, Customer actuallyCustomer) {
        assertNotNull(expectedCustomer);
        assertNotNull(actuallyCustomer);
        assertEquals(expectedCustomer.getAddress(), actuallyCustomer.getAddress());
        assertEquals(expectedCustomer.getCustomerId(), actuallyCustomer.getCustomerId());
        assertEquals(expectedCustomer.getCompany(), actuallyCustomer.getCompany());
        assertEquals(expectedCustomer.getName(), actuallyCustomer.getName());
        assertEquals(expectedCustomer.getPhone(), actuallyCustomer.getPhone());
        assertEquals(expectedCustomer.getWebsite(), actuallyCustomer.getWebsite());
        assertEquals(expectedCustomer.getEmail(), actuallyCustomer.getEmail());
        assertEquals(expectedCustomer.getUsername(), actuallyCustomer.getUsername());
    }


    /**
     * verify data customer is not null.
     * @param customer
     */
    public static void assertNotNullCustomer(Customer customer) {
        assertNotNull(customer);
        assertNotNull(customer.getAddress());
        assertNotNull(customer.getCompany());
        assertNotNull(customer.getCustomerId());
        assertNotNull(customer.getName());
        assertNotNull(customer.getPhone());
        assertNotNull(customer.getUsername());
        assertNotNull(customer.getWebsite());
        assertNotNull(customer.getEmail());
    }

    /**
     * verify user data is not null.
     * @param address data object.
     */
    public static void assertNotNullAddress(Address address) {
        assertNotNull(address);
        assertNotNull(address.getStreet());
        assertNotNull(address.getCity());
        assertNotNull(address.getGeo());
    }

    /**
     * verify customer data is not null.
     * @param company data object.
     */
    public static void assertNotNullCompany(Company company) {
        assertNotNull(company);
        assertNotNull(company.getName());
    }

}
