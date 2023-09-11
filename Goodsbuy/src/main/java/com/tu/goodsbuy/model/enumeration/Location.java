package com.tu.goodsbuy.model.enumeration;

public enum Location {

    LOC_01("서울특별시"),
    LOC_02("부산광역시"),
    LOC_03("대구광역시"),
    LOC_04("인천광역시"),
    LOC_05("광주광역시"),
    LOC_06("대전광역시"),
    LOC_07("울산광역시"),
    LOC_08("세종특자치시"),
    LOC_09("경기도"),
    LOC_10("강원특별자치도"),
    LOC_11("충청북도"),
    LOC_12("충청남도"),
    LOC_13("전라북도"),
    LOC_14("전라남도"),
    LOC_15("경상북도"),
    LOC_16("경상남도"),
    LOC_17("제주특별자치도");

    private final String locName;

    Location(String locName) {
        this.locName = locName;
    }

    public String getLocName() {
        return locName;
    }

}
