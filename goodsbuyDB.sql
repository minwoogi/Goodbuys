drop table if exists member_user;

create table member_user
(
    user_no  BIGINT AUTO_INCREMENT,
    user_id  varchar(20) NOT NULL UNIQUE,
    user_pwd varchar(20) NOT NULL,
    PRIMARY KEY (user_no)
);

ALTER TABLE member_user
    AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS member_profile;

create table member_profile
(
    profile_id   BIGINT AUTO_INCREMENT,
    user_no      BIGINT      NOT NULL UNIQUE,
    nickname     varchar(12) NOT NULL,
    join_date    DATETIME    NOT NULL,
    update_date  DATETIME    NOT NULL,
    email        VARCHAR(50) UNIQUE,
    cell_phone   VARCHAR(128) UNIQUE,
    introduction TEXT,
    image_url    VARCHAR(200),
    birthday     VARCHAR(128),
    PRIMARY KEY (profile_id),
    FOREIGN KEY (user_no) REFERENCES member_user (user_no)
        ON DELETE CASCADE
);

alter table member_profile
    auto_increment = 1;

create table product
(
    product_no        BIGINT AUTO_INCREMENT,
    product_name      VARCHAR(20) NOT NULL,
    product_image_url VARCHAR(2083),
    product_price     INT NOT NULL,
    locaiton_no       TINYINT NOT NULL,
    PRIMARY KEY (product_no)
);

ALTER TABLE product AUTO_INCREMENT=1;




