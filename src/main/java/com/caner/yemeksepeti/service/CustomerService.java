package com.caner.yemeksepeti.service;

import com.caner.yemeksepeti.dto.request.ActivationRequestDto;
import com.caner.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.caner.yemeksepeti.dto.request.LoginRequestDto;
import com.caner.yemeksepeti.dto.response.LoginResponseDto;
import com.caner.yemeksepeti.dto.response.RegisterResponseDto;
import com.caner.yemeksepeti.exception.CustomerManagerException;
import com.caner.yemeksepeti.exception.ErrorType;
import com.caner.yemeksepeti.mapper.ICustomerMapper;
import com.caner.yemeksepeti.repository.entity.Customer;
import com.caner.yemeksepeti.repository.entity.enums.EStatus;
import com.caner.yemeksepeti.repository.view.ICustomerRepository;
import com.caner.yemeksepeti.utility.CodeGenerator;
import com.caner.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository){
        super(iCustomerRepository);
        this.iCustomerRepository=iCustomerRepository;
    }

    public RegisterResponseDto register(CustomerRegisterRequestDto dto){
        Customer customer = ICustomerMapper.INSTANCE.toCustomer(dto);
        if (dto.getPassword().equals(dto.getRepassword())) {
            customer.setActivationCode(CodeGenerator.generateCode());
            save(customer);
        }else{
            throw new CustomerManagerException(ErrorType.PASSWORD_ERROR);
            }
        RegisterResponseDto responseDto = ICustomerMapper.INSTANCE.toResponse(customer);
        return responseDto;
        }


    public Boolean activateStatus(ActivationRequestDto dto){
        Optional<Customer> customer = findById(dto.getId());
        if(customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.USER_NOT_FOUND);
        }else if(customer.get().getActivationCode().equals(dto.getActivationCode())){
            customer.get().setEstatus(EStatus.ACTIVE);
            update(customer.get());
            return true;
        }
        throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);
}
public Boolean login(LoginRequestDto dto){
        Optional<Customer> customer = iCustomerRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.LOGIN_ERROR);
        }else if (!customer.get().getEstatus().equals(EStatus.ACTIVE)){
            throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }; return true;
}

}
