package com.caner.yemeksepeti.service;

import com.caner.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.caner.yemeksepeti.dto.request.SaveOrderRequestDto;
import com.caner.yemeksepeti.dto.response.RegisterResponseDto;
import com.caner.yemeksepeti.dto.response.SaveOrderResponseDto;
import com.caner.yemeksepeti.exception.CustomerManagerException;
import com.caner.yemeksepeti.exception.ErrorType;
import com.caner.yemeksepeti.mapper.ICustomerMapper;
import com.caner.yemeksepeti.mapper.IOrderMapper;
import com.caner.yemeksepeti.repository.entity.Customer;
import com.caner.yemeksepeti.repository.entity.Order;
import com.caner.yemeksepeti.repository.view.IOrderRepository;
import com.caner.yemeksepeti.utility.CodeGenerator;
import com.caner.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order,Long > {
    private final IOrderRepository iOrderRepository;

    public OrderService(IOrderRepository iOrderRepository){
        super(iOrderRepository);
        this.iOrderRepository=iOrderRepository;
    }
    /*
    public void save(SaveOrderRequestDto dto){
      Optional<Order> order  = iOrderRepository.findOptionalByProductId();
        if (order.isEmpty()) {
            throw new CustomerManagerException(ErrorType.PRODUCT_ERROR);
        }else{
            save(order);
        }
        SaveOrderResponseDto responseDto = IOrderMapper.INSTANCE.toResponse(order);
        return responseDto;
    }

     */
    public void save(SaveOrderRequestDto dto){
        save(IOrderMapper.INSTANCE.toOrder(dto));
    }

    public List<Order> findAllOrderByCustomerId(Long customerId){
        return iOrderRepository.findAllOrderByCustomerId(customerId);
    }
    public List<Order> findAllOrderByRestaurantId(Long restaurantID){
        return iOrderRepository.findAllOrderByRestaurantId(restaurantID);
    }

}
