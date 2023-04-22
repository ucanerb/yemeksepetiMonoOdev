package com.caner.yemeksepeti.controller;

import com.caner.yemeksepeti.dto.request.ActivationRequestDto;
import com.caner.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.caner.yemeksepeti.dto.request.LoginRequestDto;
import com.caner.yemeksepeti.dto.response.RegisterResponseDto;
import com.caner.yemeksepeti.repository.entity.Customer;
import com.caner.yemeksepeti.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.caner.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivationRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
