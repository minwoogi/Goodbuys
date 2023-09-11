package com.tu.goodsbuy.repository;


import com.tu.goodsbuy.model.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ListRepository {

    @Select("SELECT * FROM product WHERE location = #{location}")
    List<Product> getProductListByLocation(String location);


}
