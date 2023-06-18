drop table if exists 근무;
drop table if exists 직원;
drop table if exists 부서;


create table 직원 (
직원번호 integer primary key, 
직원이름 varchar(20),
나이 integer,
급여 decimal
);

create table 근무 (
직원번호 integer primary key,
부서번호 integer,
근무시간 integer
);

create table 부서 (
부서번호 integer primary key,
부서이름 varchar(20),
예산 decimal,
부서장번호 integer not null
);


insert into 직원 values(1, 'lee', 25, 230);
insert into 직원 values(2, 'kim', 26, 250);
insert into 부서 values(1, 'HR', 30000.0, 1);
insert into 부서(부서번호, 부서이름, 예산, 부서장번호) values(2, 'HR', 20000.0, 2);
insert into 근무 values(1, 1, 52);
insert into 근무 values(2, 2, 48);



select * from 직원;
select * from 부서; 
select * from 근무;

alter table 근무 add constraint fk_부서번호 foreign key(부서번호) references 부서(부서번호) on delete cascade;
alter table 직원 add constraint fk_직원번호 foreign key(직원번호) references 근무(직원번호) on delete cascade;


set sql_safe_updates =0;
update 직원 set 급여 = 급여 * 1.1;
select * from 직원;


delete from 부서 where 부서이름 = 'HR';












