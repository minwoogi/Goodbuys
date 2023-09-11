package com.tu.goodsbuy.model.enumeration;

public enum Category {

    CD_DVD("CD/DVD"),
    BOOK("도서"),
    CLOTHES("의류"),
    TECH_IT("테크/IT"),
    ACCESSORY("패션잡화"),
    ETC("기타");


    private final String categoryName;

    Category(String korName) {
        this.categoryName = korName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
