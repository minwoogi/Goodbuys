package com.tu.goodsbuy.repository;


import com.tu.goodsbuy.model.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DibsRepository {


    @Select("SELECT p.*" +
            "FROM product p" +
            "JOIN member_dibs d ON p.product_no = d.product_no" +
            "WHERE d.user_no = #{userNo};")
    List<Product> getDibsProductListByUserNo(Long userNo);

}
