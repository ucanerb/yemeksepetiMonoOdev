package com.caner.yemeksepeti.controller;

import com.caner.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.caner.yemeksepeti.repository.entity.Restaurant;
import com.caner.yemeksepeti.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.caner.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RESTAURANT)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveRestaurantRequestDto dto){
        restaurantService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }

}
