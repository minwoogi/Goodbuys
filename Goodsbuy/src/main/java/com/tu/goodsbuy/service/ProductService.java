package com.tu.goodsbuy.service;


import com.tu.goodsbuy.controller.param.ProductCreateParam;
import com.tu.goodsbuy.controller.param.ProductUpdateParam;
import com.tu.goodsbuy.global.exception.*;
import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {


    private final ProductRepository productRepository;


    public List<Product> getProductListByLocation(String location) {
        List<Product> productList = productRepository.getProductListByLocation(location);
       /* if (productList.isEmpty()) {
            throw new NoProductListException();
        }*/
        return productList;
    }

    public List<Product> getSearchProductListByProductNameAndLocation(String location, String productName) {
        List<Product> productList = productRepository.getSearchProductListByProductNameAndLocation(location, productName);
        /*if (productList.isEmpty()) {
            throw new NoProductListException();
        }*/
        return productList;
    }

    public List<Product> getDibsProductListByUserNo(Long userNo) {
        return productRepository.getDibsProductListByUserNo(userNo);
    }

    public List<Product> getSalesItemsProductListByUserNo(Long userNo) {
        return productRepository.getSalesItemsProductListByUserNo(userNo);
    }

    public List<Product> getSalesHistoryProductListByUserNo(Long userNo) {
        return productRepository.getSalesHistoryProductListByUserNo(userNo);
    }

    public Product getProductByProductNo(Long productNo) {
        return productRepository.getProductListByProductNo(productNo).orElseThrow(ProductNotFoundException::new);
    }

    public int getDibsCountProductByProductNo(Long productNo) {
        return productRepository.getDibsCountProductByProductNo(productNo);
    }

    public void increaseViewByProductNo(Long productNo) {
        if (productRepository.increaseViewByProductNo(productNo) == 0) {
            throw new IncreaseViewCountException();
        }
    }

    public void deleteProductByProductNo(String productNo) {
        if (productRepository.deleteProductByProductNo(productNo) == 0) {
            throw new DeleteProductException();
        }
    }

    public String getProductImageUrlByProductNo(String productNo) {
        return productRepository.getProductImageUrlByProductNo(productNo);
    }


    public void updateProductImgUrlByProductNo(String imgURL, String productNo) {
        if (productRepository.updateProductImgUrlByProductNo(imgURL, productNo) == 0) {
            throw new UpdateProductImageException();
        }
    }

    public void updateProductInfoByProductUpdateParam(ProductUpdateParam productUpdateParam) {

        String productNo = productUpdateParam.getProductNo();
        String productName = productUpdateParam.getProductName();
        String productPrice = productUpdateParam.getProductPrice();
        String productInfo = productUpdateParam.getProductInfo();

        if (productRepository.updateProductInfoByProductUpdateParam(productNo, productName, productPrice, productInfo) == 0) {
            throw new ProductUpdateException();
        }
    }

    public void registerDibsProduct(Long userNo, String productNo) {
        if (productRepository.registerDibsProduct(userNo, productNo) == 0) {
            log.error("관심상품 등록 error");

        }
    }

    public void deleteDibsProduct(Long userNo, String productNo) {
        if (productRepository.deleteDibsProduct(userNo, productNo) == 0) {
            log.error("관심상품 삭제 error");
        }
    }

    public boolean isDibs(Long userNo, String productNo) {
        return productRepository.isDibs(userNo, productNo) == 1;
    }

    public void registerSoldOut(String productNo) {
        if (productRepository.registerSoldOut(productNo) == 0) {

        }
    }

    public void createProduct(Long userNo, String nickname, String url, MemberProfile profile, ProductCreateParam productCreateParam) {


        String info = productCreateParam.getProductInfo();
        String price = productCreateParam.getProductPrice();
        String name = productCreateParam.getProductName();
        String categoryNo = productCreateParam.getCategoryNo();

        if (productRepository.createProduct(userNo, nickname, name, url, price, profile.getLocation(), categoryNo, info) == 0) {
            throw new ProductCreateException();
        }

    }
}
