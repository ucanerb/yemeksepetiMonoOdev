package com.caner.yemeksepeti.controller;

import com.caner.yemeksepeti.dto.request.SaveProductRequestDto;
import com.caner.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.caner.yemeksepeti.repository.entity.Product;
import com.caner.yemeksepeti.repository.entity.Restaurant;
import com.caner.yemeksepeti.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.caner.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveProductRequestDto dto){
        productService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
   /* @GetMapping(FIND_ALL_PRODUCT_BY_RESTAURANTID)
    public ResponseEntity<List<Product>> findAllProductByRestaurantId(@PathVariable Long restaurantId){
        return ResponseEntity.ok(productService.findAllProductByRestaurantId(restaurantId));
    }

    */

}
