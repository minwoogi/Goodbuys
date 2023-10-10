package com.tu.goodsbuy.repository;


import com.tu.goodsbuy.model.dto.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductRepository {

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


    @Select("SELECT * FROM product WHERE user_no=#{userNo} and sale_state = 0")
    List<Product> getSalesItemsProductListByUserNo(Long userNo); // 판매 중인 상품

    @Select("SELECT * FROM product WHERE user_no=#{userNo} and sale_state = 1")
    List<Product> getSalesHistoryProductListByUserNo(Long userNo); //판매 완료 상품


    @Select("SELECT * FROM product WHERE product_no = #{productNo}")
    Optional<Product> getProductListByProductNo(Long productNo);


    @Select("SELECT COUNT(*) FROM member_dibs WHERE product_no = #{productNo}")
    int getDibsCountProductByProductNo(Long productNo);


    @Update("UPDATE product SET view = view + 1 WHERE product_no = #{productNo}")
    int increaseViewByProductNo(Long productNo);

    @Delete("DELETE FROM product WHERE product_no =#{productNo}")
    int deleteProductByProductNo(String productNo);


    @Select("SELECT product_image_url FROM product WHERE product_no = #{productNo}")
    String getProductImageUrlByProductNo(String productNo);


    @Update("UPDATE product SET product_image_url=#{imageURL} WHERE product_no =#{productNo}")
    int updateProductImgUrlByProductNo(@Param("imageURL") String imgURL, @Param("productNo") String productNo);


    @Update("UPDATE product " +
            "SET product_name = #{productName}, " +
            "    product_price = #{productPrice}, " +
            "    product_info = #{productInfo} " +
            "WHERE product_no = #{productNo}")
    int updateProductInfoByProductUpdateParam(@Param("productNo") String productNo, @Param("productName") String productName,
                                              @Param("productPrice") String productPrice, @Param("productInfo") String productInfo);


    @Insert("INSERT INTO member_dibs(user_no,product_no) VALUES(#{userNo} , #{productNo})")
    int registerDibsProduct(@Param("userNo") Long userNo, @Param("productNo") String productNo);

    @Delete("DELETE FROM member_dibs WHERE user_no = #{userNo} and product_no = #{productNo}")
    int deleteDibsProduct(@Param("userNo") Long userNo, @Param("productNo") String productNo);


    @Select("SELECT COUNT(*) FROM member_dibs WHERE  user_no = #{userNo} and product_no = #{productNo}")
    int isDibs(@Param("userNo") Long userNo, @Param("productNo") String productNo);


    @Update("UPDATE product SET sale_state=1 WHERE product_no =#{productNo}")
    int registerSoldOut(@Param("productNo") String productNo);

    @Insert("INSERT INTO " +
            "product(user_no,nickname,product_name, product_image_url, product_price , location, category_no ,product_info) " +
            "values(#{userNo} , #{nickname} , #{name} , #{url} , #{price}, #{location} , #{categoryNo} , #{info})")
    int createProduct(@Param("userNo") Long userNo, @Param("nickname") String nickname, @Param("name") String productName,
                      @Param("url") String productImageUrl, @Param("price") String productPrice, @Param("location") String location,
                      @Param("categoryNo") String categoryNo, @Param("info") String info);
}
