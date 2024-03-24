package dev.patika.vetproject.api;

import dev.patika.vetproject.business.abstracts.ICustomerService;
import dev.patika.vetproject.core.config.modelMapper.IModelMapperService;
import dev.patika.vetproject.core.result.Result;
import dev.patika.vetproject.core.result.ResultData;
import dev.patika.vetproject.core.utilities.ResultHelper;
import dev.patika.vetproject.dto.request.customer.CustomerSaveRequest;
import dev.patika.vetproject.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vetproject.dto.response.CursorResponse;
import dev.patika.vetproject.dto.response.customer.CustomerResponse;
import dev.patika.vetproject.entities.Customer;
import jakarta.validation.Valid;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
//------------------------------------------------------------------------------------------------------
    //Dependency Injection
    private final ICustomerService customerService;
    private final IModelMapperService modelMapper;

    public CustomerController(ICustomerService customerService, IModelMapperService modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

//------------------------------------------------------------------------------------------------------
    //save metodu
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save (@Valid @RequestBody CustomerSaveRequest customerSaveRequest){
    Customer saveCustomer = this.modelMapper.forRequest().map(customerSaveRequest, Customer.class);
    this.customerService.save(saveCustomer);
                // CustomerResponse customerResponse = this.modelMapper.forResponse().map(saveCustomer,CustomerResponse.class);
    return ResultHelper.created(this.modelMapper.forResponse().map(saveCustomer,CustomerResponse.class));
                //new ResultData<>(true,"Veri Eklendi", "201", customerResponse);
    }
//------------------------------------------------------------------------------------------------------
    //isim ile arama
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> findByName (@PathVariable ("name") String name) {
        Customer customer = customerService.findByName(name);
        CustomerResponse customerResponse = this.modelMapper.forResponse().map(customer, CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }
//------------------------------------------------------------------------------------------------------
//Id ile arama
@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public ResultData<CustomerResponse> get (@PathVariable ("id") int id) {
    Customer customer = customerService.get( id);
    CustomerResponse customerResponse = this.modelMapper.forResponse().map(customer, CustomerResponse.class);
    return ResultHelper.success(customerResponse);
}
//------------------------------------------------------------------------------------------------------
// Pagination
@GetMapping
@ResponseStatus(HttpStatus.OK)
public Page<CustomerResponse> cursor (

        @RequestParam(name = "page", required = false, defaultValue = "0") int page,
        @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize

        )
{
    Page<Customer> customerPage = this.customerService.cursor(page, pageSize);
    Page<CustomerResponse> customerResponsePage = customerPage
            .map(customer -> this.modelMapper.forResponse().map(customer, CustomerResponse.class));

    return customerResponsePage;
}

//------------------------------------------------------------------------------------------------------
//Update metodu
@PutMapping
@ResponseStatus(HttpStatus.OK)
public ResultData<CustomerResponse> update (@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
    Customer updateCustomer = this.modelMapper.forRequest().map(customerUpdateRequest, Customer.class);
    this.customerService.update(updateCustomer);
    return ResultHelper.success(this.modelMapper.forResponse().map(updateCustomer,CustomerResponse.class));
}
//------------------------------------------------------------------------------------------------------
//Delete Metodu

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Result delete (@PathVariable ("id") long id) {
    this.customerService.delete(id);
        return ResultHelper.ok();
}
    }



