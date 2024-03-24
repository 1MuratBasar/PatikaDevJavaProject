package dev.patika.vetproject.business.concretes;

import dev.patika.vetproject.business.abstracts.ICustomerService;
import dev.patika.vetproject.core.exception.NotFoundException;
import dev.patika.vetproject.core.utilities.Msg;
import dev.patika.vetproject.dao.CustomerRepo;
import dev.patika.vetproject.entities.Customer;

import org.hibernate.query.SelectionQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Customer get(int id) {
        return this.customerRepo.findById((long) id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Customer findByName(String name) {

        return this.customerRepo.findByName(name);
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        return this.customerRepo.findAll(pageable);
    }

    @Override
    public Customer update(Customer customer) {
        this.get((int) customer.getId());
        return this.customerRepo.save(customer);
    }

    @Override
    public boolean delete(long id) {
        Customer customer = this.get((int) id);
        this.customerRepo.delete(customer);
                return true;
    }


}

