package dev.patika.vetproject.business.concretes;

import dev.patika.vetproject.business.abstracts.ICustomerService;
import dev.patika.vetproject.dao.CustomerRepo;
import dev.patika.vetproject.entities.Customer;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
//------------------------------------------------------------------------------------------------------
    //Dependency Injection
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
//------------------------------------------------------------------------------------------------------

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer getByName(String name) {

        //Burada kaldım
    }
}

