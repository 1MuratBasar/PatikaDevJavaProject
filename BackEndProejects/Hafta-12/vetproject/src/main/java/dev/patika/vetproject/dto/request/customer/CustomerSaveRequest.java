package dev.patika.vetproject.dto.request.customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    @NotNull (message = "Müşteri ismi boş olamaz")
    @NotEmpty
    private String name;

    @NotNull (message = "Telefon bilgisi boş olamaz")
    @NotEmpty
    private String phone;


    private String mail;
    private String address;
    private String city;

}
