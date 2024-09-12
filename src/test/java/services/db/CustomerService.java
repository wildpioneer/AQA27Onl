package services.db;

import dao.CustomerDao;
import models.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();


    public Customer findCustomer(int id) {
        return customerDao.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }
}
