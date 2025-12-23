package com.kunal.ProductService.Service;

import com.kunal.ProductService.Dto.ProductDTO;
import com.kunal.ProductService.Entity.Product;
import com.kunal.ProductService.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepo productRepo;

    ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public List<ProductDTO> getAllProducts(){
        List<Product> products= productRepo.findAll();
        return products.stream().map(this::mapToProductDTO).toList();

    }


    public ProductDTO mapToProductDTO(Product product){
        return new ProductDTO(
                product.getName(),
                product.getPrice()
        );
    }

}
