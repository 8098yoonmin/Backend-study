use datamotionmoviedatabase;

-- 1. DBManager 라는 이름을 가지는 사용자를 작성하세요.
create user DBManager identified by '1234';

-- 2. User 라는 이름을 가지는 사용자를 작성하세요.
create user User identified by '1234';

-- 3. DBManger 사용자는 DatamotionMovieDatabase의 모든 개체에 모든 권한을 가지되, 다른 데이터베이스에 대한 권한은 가지지 않아야 합니다.
grant all on datamotionmoviedatabase.* to celine;

-- 4. User 사용자는 가지는 데이터베이스의 모든 개체에 대한 읽기 권한과, PersonTrivia 테이블과 MovieTrivia 테이블에는 읽기 및 쓰기 권한을 가집니다.
grant select on * to User;
grant update on datamotionmoviedatabase.PersonTrivia to User;
grant update on datamotionmoviedatabase.MovieTrivia to User;

-- 5. '영화'에 출연한 '배우'와 관련된 뷰를 작성하세요.
create view actorinfo
as
	select p.* , m.*
from 
	person p join appear a on p.personid = a.personid
	join role r on r.roleid = a.roleid
    join movie m on m.movieid = a.movieid
where rolekorname='배우';
		

-- 6. '영화'를 감독한 '감독'과 관련된 뷰를 작성하세요.
create view directorinfo
as 
	select m.*, p.*
from
	person p join appear a on p.personid = a.personid
    join role r on r.roleid = a.roleid
    join movie m on m.movieid = a.movieid
where rolekorname= '감독';


-- 7. '아카데미 시상 결과'과 관련된 뷰를 작성하세요.
create view winornotinfo
as 
	select distinct m.title, w.winornot
from 
	winning w join awardinvolve ai on w.winningid = ai.winningid
	join appear a on a.appearid = ai.appearid
    join movie m on m.movieid = a.movieid;


-- 8. '영화 장르별 제작비와 흥행 수익'에 관련된 뷰를 작성하세요.
create view budgetgrossinfo
as
	select m.budget, m.boxofficewwgross, g.genrename
from 
	movie m join moviegenre mg on m.movieid = mg.movieid
    join genre g on g.genreid = mg.genreid;


-- 9. 영화 '매트릭스' 의 감독이 몇명인지 출력하세요
select count(rolekorname)
from 
	movie as m join appear as a on m.movieid = a.movieid
    join role as r on a.roleid = r.roleid
where 
	rolekorname = '감독' and koreantitle = '매트릭스';
    

-- 10. 상영시간이 100분 이상인 영화 중 레오나르도 디카프리오가 출연한 영화를 출력하세요.
select title
from 
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where 
	m.runningtime >= 100 and r.rolekorname = '배우' and p.koreanname = '레오나르도 디카프리오';


-- 11. '알란 실버스트리'가 음악을 작곡한 영화와 '애런 소킨'이 각본을 쓴 영화를 출력하세요. (애런 소킨 데이터를 찾아보세요)
select title, koreanname
from 
	movie m join appear a on m.movieid = a.movieid
    join role r on a.roleid = r.roleid
    join person p on p.personid = a.personid
where 
	(r.rolekorname='작곡' and p.koreanname='알란 실버스트리') or (r.rolekorname='각본가' and p.koreanname='아론 소킨');


-- 12. '쿠엔틴 타란티노'가 감독한 영화에 출연한 배우들이 출연한 영화의 수익율을 배우별로 출력하세요.
select SUM(boxofficewwgross - budget)/ sum(budget) * 100 as 수익률 , name
from
	actorinfo
where title in (
	select title 
	from directorinfo
	where koreanname = '쿠엔틴 타란티노'
	)
group by name;


-- 13. 위 문제들 중, 생성한 뷰에서 질의가 어려운 쿼리에 대한 뷰를 작성하세요.
create view earninfo
as 
select SUM(boxofficewwgross - budget)/ sum(budget) * 100 as 수익률 , name
from
	actorinfo
where title in (
	select title 
	from directorinfo
	where koreanname = '쿠엔틴 타란티노'
	)
group by name;


-- 14. 새로 생성한 뷰를 사용해서 쿼리를 다시 작성하세요.
select 수익률
from 
	earninfo
where 
	name = 'Jamie Foxx';

-- 14. 사용자 테이블을 작성하세요. 사용자 테이블은 사용자의 ID, 이름, 패스워드, 전자메일 주소를 필드로 가집니다.
create table `User` (
	userid int,
    username nvarchar(20),
    userpassword nvarchar(20),
    email nvarchar(30)
);

insert into user values(1,'김윤민', '1234', 'ksw08120@naver');
select * from user;

-- 15. 사용자가  MovieTrivia 테이블과 PersonTrivia 테이블에 투플을 삽입할 수 있고, 각 투플에 삽입한 사용자를 식별할 수 있는 정보가 포함되어야 할 때, 두 테이블의 릴레이션 스키마를 수정하세요
# user id / movietrivia persontrivia 테이블에 추가 
alter table movietrivia add userid int;
alter table persontrivia add userid int;

-- 16. 수정된 테이블 두 테이블(MovieTrivia, PersonTrivia)과 사용자 테이블 사이의 참조 무결성을 위한 제약조건을 설정하세요.
#foreign key / primary key 연결하기 
alter table `User` add constraint pk_userid primary key(userid);
alter table movietrivia add constraint fk_mtrivia foreign key(userid) references user(userid);
alter table persontrivia add constraint fk_ptrivia foreign key(userid) references user(userid);


-- 17. User 사용자가 두 테이블(MovieTrivia, PersonTrivia)에 데이터를 삽입할 수 있도록 권한을 설정하세요.
grant insert on datamotionmoviedatabase.movietrivia to `User`;
grant insert on datamotionmoviedatabase.persontrivia to `User`;

-- 18. MovieTrivia 테이블에 데이터를 삽입하는 저장 프로시저를 작성하세요.
delimiter $$
create procedure insertdata(TriviaId int,movieid int, userid int)
begin 
		insert into movietrivia values(Triviaid, movieid, userid);
	end $$
delimiter ;

-- movietrivia의 triviaid가 trivia테이블의 외래키이므로 , trivia 내의 triviaid 에 존재하는 값을 넣어줘야함. 
-- movieid도 movie를 참조하고 있으므로 거기서 있는 가져다 써야함.
-- userideh usert테이블 내에 존재하는 데이터를 넣어야함
call insertdata(1, 13612, 1);
select * from movietrivia;

-- 19. PersonTrivia 테이블에 데이터를 삽입하는 저장 프로시저를 작성하세요.
delimiter $$
create procedure insertdata2(TriviaId int, personid int, userid int)
begin 
	insert into persontrivia values(triviaid, movieid, userid);
end $$
delimiter ;
alter


-- 20. 주어진 감독이 감독한 영화를 모두 출력하는 저장 프로시저를 작성하세요.
DELIMITER $$
create procedure gettitle
(
directname varchar(200)
)
begin
select distinct m.title
	from movie m join appear a on m.movieid = a.movieid
    join person p on p.personid = a.personid
    join role r on r.roleid = a.roleid
where
	p.koreanname = directname and rolekorname= '감독'; 
    
end $$
DELIMITER ;


call gettitle('쿠엔틴 타란티노');


-- 21. 주어진 영화에 출연한 배우를 모두 출력하는 저장 프로시저를 작성하세요.
delimiter $$
create procedure getactor(
moviename varchar(200)
)
begin
select p.name
	from movie m join appear a on m.movieid = a.movieid
    join person p on p.personid = a.personid
    join role r on r.roleid = a.roleid
where
	rolekorname= '배우' and koreantitle = moviename ;
end $$
delimiter ;

call getactor('빅 히어로');


-- 22. 주어진 영화에 참여한, 감독, 각본, 배우를 제외한 모든 사람을 출력하는 저장 프로시저를 작성하세요.
delimiter $$
create procedure getpeople(
moviename varchar(200)
)
begin
select p.name
from movie m join appear a on m.movieid = a.movieid
    join person p on p.personid = a.personid
    join role r on r.roleid = a.roleid
where
	rolekorname <> '감독' and rolekorname <> '각본' and rolekorname <> '배우' 
	and koreantitle = moviename;
end $$
delimiter ;

call getpeople('빅 히어로');


-- 23. 주어진 사람이 '참여'한 영화를 출력하는 저장 프로시저를 작성하세요.
delimiter $$
create procedure getmovietitle(
partperson varchar(200)
)
begin
select title
from 
	movie m join appear a on m.movieid = a.movieid
    join person p on p.personid = a.personid
where
	p.koreanname = partperson;
end $$
delimiter ;

call getmovietitle('쿠엔틴 타란티노');

-- 24. 주어진 장르에 대한 제작비, 전체 수익과 수익율을 출력하는 저장 프로시저를 작성하세요.
delimiter $$
create procedure printearning(
genrekorname varchar(200)
)
begin
select sum(m.budget), sum(m.boxofficewwgross), sum(boxofficewwgross-budget)/sum(budget) *100 as 수익률, genrekorname
from 
	movie m join moviegenre mg on m.movieid = mg.movieid
    join genre g on g.genreid = mg.genreid
where
	genrekorname = genrekorname
group by genrekorname;
end $$
delimiter ;

-- 집계함수 쓰려면 groupby 절을 작성해야함
drop procedure printearning;

call printearning('로맨스');

-- <수업하지 않은 내용>
-- 25. 저장 프로시저의 파라미터는 출력/입력/입출력 형태의 파라미터를 가질 수 있습니다. 주어진 영화(MovieID)로 출연/참여자 정보를 제외한 모든 정보를 출력 파라미터로 가지고, 실행 결과가 출력 파라미터에 기록되도록 하는 저장 프로시저를 작성하세요.