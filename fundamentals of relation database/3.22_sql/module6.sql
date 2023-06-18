create database module06;
use module06;

drop table if exists reservation;
drop table if exists passenger;
drop table if exists aircraft;
drop table if exists flight;



create table passenger (
	passengerNo int,
    passengerName nvarchar(10) not null,
    grade int check( grade>= 1 and grade <=10) default 1,
    age int null,
    constraint pk_passenger primary key(passengerNo)
);

insert into passenger values(1,'홍길동', 7, 44);
insert into passenger (passengerNo, passengerName, age) values(2,'이순신', 44);

-- insert into passenger(passengerNo, grade, age) values(3,7,40);
insert into passenger(passengerNo, passengerName, grade) values(3,'안중근',7);
insert into passenger values(4,'김영랑', 9, 54);
insert into passenger values(5,'김소월', 9, 45);
insert into passenger values(6,'윤동주', 10, 26), (7,'천상병', 8, 55);

select * from passenger;

-- 테이블을 만들기 전에 현재 db를 확인하는 버릇을 들어야 한다. 
select database();

create table aircraft(
	AircraftNo int,
    KindOfAircraft varchar(20),
    Airline varchar(10)
);

-- 기본키 추가
alter table aircraft add constraint pk_aircraft primary key(aircraftNo);
-- 수정
alter table aircraft modify column KindOfAircraft varchar(20) not null;
insert into aircraft values(101, 'Boeing 747', '대한항공');
insert into aircraft values (102, 'Boeing 727', '대한항공'),
(103, 'Airbus A380', '아시아나항공'),
(104, 'Airbus A300', '대한항공'),
(105, 'Boeing 737-800', '제주항공');

select * from aircraft;

create table flight (
	FlightNo int,
    AircraftNo int,
    Deparetures nvarchar(10) not null,
    Arrival nvarchar(10) not null,
    Price int default 0,
    FlightDate datetime not null,
    constraint pk_Flight primary key(FlightNo),
    constraint fk_Flight_Aircraft foreign key(AircraftNo) references Aircraft(AircraftNo)
    );
    

insert into flight values(1,101,'인천','샌프란시스코',1230000, '2022-10-23 10:20');
insert into flight values(2, 101,'샌프란시스코','인천',1230000,'2022-10-26 13:00');
insert into flight values(3, 105, '김포','제주', 72000,'2022-11-23 09:00');
insert into flight values
(4, 105, '김포','김해', 68000, '2022-11-12 17:30'),
(5, 103, '인천','프랑크푸르트', 1480000, '2022-12-01 18:00'),
(6, 103, '프랑크푸르트', '인천', 1560000, '2022-12-10 10:00'),
(7, 104, '김해','김포', 70000, '2022-11-13 11:00'),
(8, 101, '인천','샌프란시스코', 1230000, '2022-11-15 10:00');

create table reservation(
	passengerNo int,
    FlightNo int,
    ReservedDate date not null,
    
    constraint pk_Reservation primary key(passengerNo, FlightNo),
    constraint fk_Reservation_Passenger foreign key(passengerNo) references Passenger(passengerNo),
    constraint fk_Reservatioin_Flight foreign key(FlightNo) references Flight(FlightNo)
    );
    
insert into reservation values
(3, 1, '2022-10-20'),
(4, 7, '2022-10-11'),
(6, 7, '2022-10-21'),
(2, 1, '2022-10-11'),
(2, 2, '2022-10-11'),
(7, 3, '2022-09-11'),
(1, 3, '2022-11-09');



select * from reservation;
select grade from passenger;
select distinct grade from passenger;
select passengerName, age from passenger where age <= 40;

select passengername, grade, aircraftno from passenger, aircraft;
select passengerno, passengername from passenger, flight;
select passengerno, passengername from passenger, reservation;
select passengername+'님' as 'name', age from passenger;

select count(*) from passenger;
select * from passenger;
select count(age) from passenger; -- Null은 집계를 안함 
select sum(age) from passenger;
select max(age) from passenger;
select avg(age) from passenger;

select kindofaircraft, airline, flightdate
from aircraft as a inner join flight as f on a.aircraftno = f.aircraftno;
select flightdate from flight where aircraftno = 101;

select 
	passengername, age
from 
	passenger as p join reservation as r on p.passengerno = r.passengerno 
	inner join flight as f on f.flightno = r.flightno 
	inner join aircraft as a on a.aircraftno = f.aircraftno
where 
	a.airline = '대한항공' ;
    

-- 똑같은 결과를 냄
select
	passengername, age
from 
	passenger as p, reservation as r, flight as f, aircraft as a
where 
	p.passengerno = r.passengerno
    and
    f.flightno = r.flightno
    and 
    a.aircraftno = f.aircraftno
    and
    a.airline = '대한항공';
