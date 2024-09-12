package dbEntries;

import models.Customer;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomerTable {

    private DataBaseService dbService;

    public CustomerTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO public.customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customer.getFirstName() +"', '" + customer.getLastName() + "', '" + customer.getEmail() + "', " + customer.getAge() + ")";

        dbService.executeSQL(sql);
    }

    public ResultSet getAllCustomers() {
        String sql = "SELECT * FROM public.customers";

        return dbService.executeQuery(sql);
    }

    public ResultSet getById(int id) {
        String sql = "SELECT * FROM public.customers WHERE id = '" + id + "'";

        return dbService.executeQuery(sql);
    }

    public void dropTable() {
        System.out.println("Dropping table");
        String sql = "DROP TABLE IF EXISTS customers;";

        dbService.executeSQL(sql);
    }

    public void createTable() {
        System.out.println("Creating table");

        String createTableSQL = "CREATE TABLE public.customers (" +
                "id SERIAL PRIMARY KEY, " +
                "firstname CHARACTER VARYING(30), " +
                "lastname CHARACTER VARYING(30), " +
                "email CHARACTER VARYING(30), " +
                "age INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

}
