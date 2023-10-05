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
    nickname     varchar(12) NOT NULL UNIQUE,
    join_date    DATETIME    NOT NULL,
    update_date  DATETIME    NOT NULL,
    email        VARCHAR(50) UNIQUE,
    cell_phone   VARCHAR(128) UNIQUE,
    introduction TEXT,
    image_url    VARCHAR(200),
    birthday     VARCHAR(128),
    location     varchar(20) NOT NULL,
    email_check  TINYINT     NOT NULL DEFAULT 0,
    PRIMARY KEY (profile_id),
    FOREIGN KEY (user_no) REFERENCES member_user (user_no)
        ON DELETE CASCADE
);

alter table member_profile
    auto_increment = 1;

DROP TABLE IF EXISTS product;

create table product
(
    product_no        BIGINT AUTO_INCREMENT,
    user_no           BIGINT      NOT NULL,
    nickname          VARCHAR(12) NOT NULL,
    product_name      VARCHAR(20) NOT NULL,
    product_image_url VARCHAR(2083),
    product_price     INT         NOT NULL,
    location          varchar(20) NOT NULL,
    category_no       TINYINT     NOT NULL,
    view              BIGINT      NOT NULL DEFAULT 0,
    make_time         DATETIME    NOT NULL DEFAULT NOW(),
    product_info      TEXT,
    PRIMARY KEY (product_no),
    FOREIGN KEY (user_no) REFERENCES member_user (user_no)
        ON DELETE CASCADE
);

ALTER TABLE product
    AUTO_INCREMENT = 1;

insert into member_user(user_id, user_pwd) value ('choo', 1234);
insert into member_profile(user_no, nickname, join_date, update_date, email, cell_phone, introduction,
                           location)
values (1, 'minwoogi', now(), now(), 'email@email.com', '01012345678', '소개', '부산광역시');

insert into member_user(user_id, user_pwd) value ('min', 1234);
insert into member_profile(user_no, nickname, join_date, update_date, email, cell_phone, introduction,
                           location)
values (2, 'min', now(), now(), 'email@email.com', '01011112222', '소개', '부산광역시');


insert into product(user_no, nickname, product_name, product_image_url, product_price, location, category_no,product_info)
values (1, 'minwoogi', '옷', 'image', 10000, '부산광역시', 2,'설명임당'),
       (1, 'minwoogi', '냉장고', 'image', 20000, '인천광역시', 2,'설명'),
       (1, 'minwoogi', '옷냉장고', 'image', 10000, '부산광역시', 2,'설명'),
       (1, 'minwoogi', '옷234', 'image', 10000, '부산광역시', 2,'설명')
;



delete
from product
where location = '부산광역시';


drop table member_dibs;

create table member_dibs
(

    dibs_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_no    BIGINT,
    product_no BIGINT,
    FOREIGN KEY (user_no) references member_user (user_no) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (product_no) references product (product_no) ON UPDATE CASCADE ON DELETE CASCADE
);

ALTER TABLE member_dibs
    AUTO_INCREMENT = 1;

INSERT INTO member_dibs(user_no, product_no)
values (1, 4);


SELECT p.*
FROM product p
         JOIN member_dibs d ON p.product_no = d.product_no
WHERE d.user_no = 1;


drop table if exists sales_product;
create table sales_product
(
    sale_no BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_no BIGINT,
    product_no BIGINT,
    sale_state TINYINT DEFAULT 0,
    FOREIGN KEY (user_no) references member_user (user_no) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (product_no) references product (product_no) ON UPDATE CASCADE ON DELETE CASCADE

);

select p.*
from product p
JOIN sales_product s ON p.product_no = s.product_no
WHERE s.user_no = 1 and s.sale_state= 0;

drop table if exists  purchase_product;
create table purchase_product
(
    purchase_no BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_no BIGINT,
    product_no BIGINT,
    FOREIGN KEY (user_no) references member_user (user_no) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (product_no) references product (product_no) ON UPDATE CASCADE ON DELETE CASCADE
);


update member_profile set email_check=0 where nickname='minwoogi';

update member_profile set image_url=null where nickname='minwoogi';
