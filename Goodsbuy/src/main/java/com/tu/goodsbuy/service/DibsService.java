package com.tu.goodsbuy.service;

import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.repository.DibsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DibsService {

    private final DibsRepository dibsRepository;


    public List<Product> getDibsProductListByUserNo(Long userNo) {
        return dibsRepository.getDibsProductListByUserNo(userNo);
    }


}
