package tests.db;

import baseEntities.BaseDBTest;
import dbEntries.CustomerTable;
import models.Customer;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlTest extends BaseDBTest {

    @Test
    public void firstDBTest() {
        CustomerTable customerTable = new CustomerTable(dbService);

        ResultSet rs = customerTable.getAllCustomers();

        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                Customer customer = new Customer(id, firstName, lastname, email, age);
                System.out.println(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void secondDBTest() {
        CustomerTable customerTable = new CustomerTable(dbService);

        customerTable.dropTable();
        customerTable.createTable();

        Customer customer = new Customer(1, "Иван", "Иванов", "ivan@test.com", 34);
        customerTable.addCustomer(customer);

        customerTable.addCustomer(new Customer(1, "Петр", "Петров", "petr@test.com", 24));
        customerTable.addCustomer(new Customer(1, "Марина", "Стасевич", "marina@test.com", 26));


        ResultSet rs = customerTable.getAllCustomers();

        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                Customer tmpCustomer = new Customer(id, firstName, lastname, email, age);
                System.out.println(tmpCustomer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
