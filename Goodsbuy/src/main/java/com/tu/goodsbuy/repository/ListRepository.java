package com.tu.goodsbuy.repository;


import com.tu.goodsbuy.model.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ListRepository {

    @Select("SELECT * FROM product WHERE location = #{location}")
    List<Product> getProductListByLocation(String location);


    @Select("SELECT * FROM product WHERE location = #{location} AND product_name LIKE CONCAT('%', #{product_name}, '%')")
    List<Product> getSearchProductListByProductNameAndLocation(@Param("location") String location,
                                                               @Param("product_name") String productName);

    @Select("SELECT p.* " +
            "FROM product p " +
            "JOIN member_dibs d ON p.product_no = d.product_no " +
            "WHERE d.user_no = #{userNo};")
    List<Product> getDibsProductListByUserNo(Long userNo);


    @Select("SELECT p.* " +
            "FROM product p " +
            "JOIN sales_product s ON p.product_no = s.product_no " +
            "WHERE s.user_no = #{userNo} and s.sale_state= 0")
    List<Product> getSalesItemsProductListByUserNo(Long userNo);

    @Select("SELECT p.* " +
            "FROM product p " +
            "JOIN sales_product s ON p.product_no = s.product_no " +
            "WHERE s.user_no = #{userNo} and s.sale_state= 1")
    List<Product> getSalesHistoryProductListByUserNo(Long userNo);


}
