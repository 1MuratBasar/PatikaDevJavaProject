package dev.patika.vetproject.business.abstracts;

import dev.patika.vetproject.entities.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {

    Customer save (Customer customer);

//    Customer getByName (String name);
    Customer get (int id);

    Customer findByName (String name);

    Page<Customer> cursor (int page , int pageSize);

    Customer update (Customer customer);


    boolean delete (long id);


}
