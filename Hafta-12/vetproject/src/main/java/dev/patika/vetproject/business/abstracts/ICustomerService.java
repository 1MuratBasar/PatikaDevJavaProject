package dev.patika.vetproject.business.abstracts;

import dev.patika.vetproject.entities.Customer;

public interface ICustomerService {

    Customer save (Customer customer);

    Customer getByName (String name);

}
