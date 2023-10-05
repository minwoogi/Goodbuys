package com.tu.goodsbuy.service;


import com.tu.goodsbuy.controller.param.ProductUpdateParam;
import com.tu.goodsbuy.global.exception.*;
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
       /* if (productList.isEmpty()) {
            throw new NoProductListException();
        }*/
        return productList;
    }

    public List<Product> getSearchProductListByProductNameAndLocation(String location, String productName) {
        List<Product> productList = listRepository.getSearchProductListByProductNameAndLocation(location, productName);
        /*if (productList.isEmpty()) {
            throw new NoProductListException();
        }*/
        return productList;
    }

    public List<Product> getDibsProductListByUserNo(Long userNo) {
        return listRepository.getDibsProductListByUserNo(userNo);
    }

    public List<Product> getSalesItemsProductListByUserNo(Long userNo) {
        return listRepository.getSalesItemsProductListByUserNo(userNo);
    }

    public List<Product> getSalesHistoryProductListByUserNo(Long userNo) {
        return listRepository.getSalesItemsProductListByUserNo(userNo);
    }

    public Product getProductByProductNo(Long productNo) {
        return listRepository.getProductListByProductNo(productNo).orElseThrow(ProductNotFoundException::new);
    }

    public int getDibsCountProductByProductNo(Long productNo) {
        return listRepository.getDibsCountProductByProductNo(productNo);
    }

    public void increaseViewByProductNo(Long productNo) {
        if (listRepository.increaseViewByProductNo(productNo) == 0) {
            throw new IncreaseViewCountException();
        }
    }

    public void deleteProductByProductNo(String productNo) {
        if (listRepository.deleteProductByProductNo(productNo) == 0) {
            throw new DeleteProductException();
        }
    }

    public String getProductImageUrlByProductNo(String productNo) {
        return listRepository.getProductImageUrlByProductNo(productNo);
    }


    public void updateProductImgUrlByProductNo(String imgURL, String productNo) {
        if (listRepository.updateProductImgUrlByProductNo(imgURL, productNo) == 0) {
            throw new UpdateProductImageException();
        }
    }

    public void updateProductInfoByProductUpdateParam(ProductUpdateParam productUpdateParam) {

        String productNo = productUpdateParam.getProductNo();
        String productName = productUpdateParam.getProductName();
        String productPrice = productUpdateParam.getProductPrice();
        String productInfo = productUpdateParam.getProductInfo();

        if (listRepository.updateProductInfoByProductUpdateParam(productNo, productName, productPrice, productInfo) == 0) {
            throw new ProductUpdateException();
        }


    }
}
