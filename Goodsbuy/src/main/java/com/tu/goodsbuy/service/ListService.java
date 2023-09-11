package com.tu.goodsbuy.service;


import com.tu.goodsbuy.exception.NoProductListException;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListService {


    private final ListRepository listRepository;


    public List<Product> getProductListByLocation(String location) {
        List<Product> productList = listRepository.getProductListByLocation(location);
        if (productList.isEmpty()) {
            throw new NoProductListException();
        }
        return productList;
    }
}