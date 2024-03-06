package dev.patika.vetproject.api;

import dev.patika.vetproject.business.abstracts.ICustomerService;
import dev.patika.vetproject.core.config.modelMapper.IModelMapperService;
import dev.patika.vetproject.core.result.Result;
import dev.patika.vetproject.core.result.ResultData;
import dev.patika.vetproject.core.utilities.ResultHelper;
import dev.patika.vetproject.dto.request.customer.CustomerSaveRequest;
import dev.patika.vetproject.dto.response.customer.CustomerResponse;
import dev.patika.vetproject.entities.Customer;
import jakarta.validation.Valid;
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

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getByName (@PathVariable ("name") String name {
        Customer customer = customerService.
    }


}
