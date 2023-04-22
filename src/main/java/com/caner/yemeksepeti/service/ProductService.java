package com.caner.yemeksepeti.service;

import com.caner.yemeksepeti.dto.request.SaveProductRequestDto;
import com.caner.yemeksepeti.mapper.IProductMapper;
import com.caner.yemeksepeti.repository.entity.Order;
import com.caner.yemeksepeti.repository.entity.Product;
import com.caner.yemeksepeti.repository.view.IProductRepository;
import com.caner.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceManager<Product, Long> {

    private  final IProductRepository iProductRepository;
    public ProductService(IProductRepository iProductRepository){
        super(iProductRepository);
        this.iProductRepository=iProductRepository;
    }
    public void save (SaveProductRequestDto dto){
        save(IProductMapper.INSTANCE.toProduct(dto));
    }


   // public List<Product> findAllProductByRestaurantId(Long restaurantId){
     //   return iProductRepository.findAllProductByRestaurantId(restaurantId);
    //}
}
