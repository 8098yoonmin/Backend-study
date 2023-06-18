create database factory;
use factory;

create table 공급자(
	공급자번호 int primary key,
    공급자이름 nvarchar(20),
    주소 nvarchar(20)
);

create table 부품(
	부품번호 int primary key,
    부품이름 nvarchar(10),
    색상 nvarchar(10)
);

create table 카탈로그(
	공급자번호 int primary key,
    부품번호 int,
    단가 decimal
);

insert into 공급자 values
(1, '가', '광주'),
(2, '나', '경남'),
(3, '다', '서울'),
(4, '라', '부산');

insert into 부품 values
(11, '나사', '검'),
(12, '너트', '흰'),
(13, '볼트', '파'),
(14, '철', '빨');

insert into 카탈로그 values
(1, 11, 130),
(2, 12, 250),
(3, 13, 220),
(4, 14, 1100);





