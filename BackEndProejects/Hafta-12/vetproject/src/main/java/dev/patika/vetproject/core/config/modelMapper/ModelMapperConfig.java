package dev.patika.vetproject.core.config.modelMapper;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// proejm her başladıgında bir tanae Model üretip bana versin
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
    return new ModelMapper();

    }
}
