package com.tu.goodsbuy.service;


import com.tu.goodsbuy.global.exception.NoProductListException;
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

    public List<Product> getSearchProductListByProductNameAndLocation(String location, String productName) {
        List<Product> productList = listRepository.getSearchProductListByProductNameAndLocation(location, productName);
        if (productList.isEmpty()) {
            throw new NoProductListException();
        }
        return productList;
    }

    public List<Product> getDibsProductListByUserNo(Long userNo) {
        return listRepository.getDibsProductListByUserNo(userNo);
    }
}
