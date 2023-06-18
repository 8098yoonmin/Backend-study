show databases;
select host, user from mysql.user;
# celine 사용자 생성
create user celine identified by '1234';
select user();
show databases; # celine사용자는 info 데이터베이스만 뜸 

# mysql에서 host는 원격접속을 한다는 의미?
select host, user from mysql.user;
grant select on module06.aircraft to celine;
revoke select on module06.aircraft from celine;

# 뷰
use module06;
create view reserveinfo
as
	select p.passengerno, p.passengername, p.grade, p.age, r.reserveddate, f.flightno
    from passenger as p inner join reservation as r on p.passengerNo = r.passengerNo
    inner join flight as f on f.flightno = r.flightno;

select * from reserveinfo;

#내부스키마에 접근 불가, 내가 보여주고 싶은 테이블을 조합해 보여줌 
grant select on module06.reserveinfo to celine;

#프로시저
DELIMITER $$
create procedure getreserveinfo()
begin
select p.passengerno, p.passengername, p.grade, p.age, r.reserveddate, f.flightno
    from passenger as p inner join reservation as r on p.passengerNo = r.passengerNo
    inner join flight as f on f.flightno = r.flightno;
end $$
DELIMITER ;

call getreserveinfo();

DELIMITER $$
create procedure getreserveinfoforpassenger
(
passenger int
)
begin
select p.passengerno, p.passengername, p.grade, p.age, r.reserveddate, f.flightno
    from passenger as p inner join reservation as r on p.passengerNo = r.passengerNo
    inner join flight as f on f.flightno = r.flightno
    where p.passengerno = passenger;
end $$
DELIMITER ;
drop procedure getreserveinfoforpassenger;
call getreserveinfoforpassenger(1);


