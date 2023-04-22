package com.caner.yemeksepeti.service;

import com.caner.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.caner.yemeksepeti.mapper.IRestaurantMapper;
import com.caner.yemeksepeti.repository.entity.Restaurant;
import com.caner.yemeksepeti.repository.view.IRestaurantRepository;
import com.caner.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {
    private final IRestaurantRepository iRestaurantRepository;

    public RestaurantService (IRestaurantRepository iRestaurantRepository){
        super(iRestaurantRepository);
        this.iRestaurantRepository=iRestaurantRepository;
    }

    public void save(SaveRestaurantRequestDto dto){
        save(IRestaurantMapper.INSTANCE.toRestaurant(dto));
    }
}
