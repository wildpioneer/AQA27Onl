package tests.db;

import models.Customer;
import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.testng.annotations.Test;
import services.db.CustomerService;

import java.util.List;

public class HibernateDBTest {

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();

        Customer customer = new Customer(1, "Ivan", "Grigoriev", "test@email.com", 28);
        customerService.saveCustomer(customer);

        List<Customer> customerList = customerService.findAllCustomers();
        for (Customer c : customerList) {
            System.out.println(c);
        }
    }
}
