use datamotionmoviedatabase;
show tables;


-- 1. 영화 '퍼스트 맨'의 제작 연도, 영문 제목, 러닝 타임, 플롯을 출력하세요.
select title, releaseyear, runningtime, plot 
from movie
where koreantitle = '퍼스트 맨';

-- 2. 2003년에 개봉한 영화의 한글 제목과 영문 제목을 출력하세요
select koreantitle, title
from movie
where releaseyear = 2003;

-- 3. 영화 '글래디에이터'의 작곡가를 고르세요
select name
from 
	person as p join appear as a on a.personid = p.personid
    join role as r on r.roleid = a.roleid
    join movie as m on m.movieid = a.movieid
where 
	koreantitle ='글래디에이터' and rolename='composer';


-- 4. 영화 '매트릭스' 의 감독이 몇명인지 출력하세요
select count(rolekorname)
from 
	movie as m join appear as a on m.movieid = a.movieid
    join role as r on a.roleid = r.roleid
where 
	rolekorname = '감독' and koreantitle = '매트릭스';
    
    
-- 5. 감독이 2명 이상인 영화를 출력하세요
select koreantitle
from 
	movie as m join appear as a on m.movieid = a.movieid
    join role as r on a.roleid = r.roleid
where rolekorname = '감독'
group by koreantitle
having count(rolekorname) >= 2 ;

-- 6. '한스 짐머'가 참여한 영화 중 아카데미를 수상한 영화를 출력하세요
select title
from 
	winning as w join awardinvolve as a on w.winningid = a.winningid 
    join appear as ap on ap.appearid = a.appearid
    join person as p on ap.personid = p.personid
    join role as r on r.roleid = ap.roleid
    join movie as m on m.movieid = ap.movieid
where 
	koreanname = '한스 짐머' and winornot = 'winner';


-- 7. 감독이 '제임스 카메론'이고 '아놀드 슈워제네거'가 출연한 영화를 출력하세요
select title, rolekorname, koreanname
from 
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where 
	(r.rolekorname = '감독' and p.koreanname = '제임스 카메론')
    and ( r.rolekorname= '배우' and p.koreanname = '아놀드 슈워제네거')
    ;
    
    
-- 8. 상영시간이 100분 이상인 영화 중 레오나르도 디카프리오가 출연한 영화를 고르시오
select title
from 
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where 
	m.runningtime >= 100 and r.rolekorname = '배우' and p.koreanname = '레오나르도 디카프리오';


-- 9. 청소년 관람불가 등급의 영화 중 가장 많은 수익을 얻은 영화를 고르시오
select title, boxofficewwgross
from 
	movie
where  boxofficewwgross = (select max(boxofficewwgross) 
							from movie as m join gradeinkorea as g on m.gradeinkoreaid = g.gradeinkoreaid
							where gradeinkoreaname = '청소년 관람불가');


-- 10. 1999년 이전에 제작된 영화의 수익 평균을 고르시오
select avg(boxofficewwgross)
from movie 
where releaseyear < 1999;

-- 11. 가장 많은 제작비가 투입된 영화를 감독한 사람은 누구입니까?
select koreanname
from 
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where rolekorname = '감독'
order by budget desc limit 1 ;

-- 12. 제작한 영화의 제작비 총합이 가장 높은 감독은 누구입니까?
select koreanname, sum(budget)
from
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where rolekorname = '감독'
group by koreanname
order by sum(budget) desc limit 1;


-- 13. 출연한 영화의 모든 수익을 합하여, 총 수입이 가장 많은 배우를 출력하세요.
select koreanname
from
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where 
	rolekorname ='배우'
group by koreanname
order by sum(boxofficewwgross) desc limit 1;

-- 14. 제작비가 가장 적게 투입된 영화의 수익을 고르세요. (제작비가 0인 영화는 제외합니다)
select boxofficewwgross
from movie
where budget <> 0
order by budget limit 1;

-- 15. 제작비가 5000만 달러 이하인 영화의 미국내 평균 수익을 고르세요
select avg(officeusgross)
from movie
where budget <= 50000000;


-- 16. 액션 장르 영화의 평균 수익을 집계하세요.
select avg(boxofficewwgross)
from 
	movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
where 
	g.genrekorname = '액션';

-- 17. 드라마, 전쟁 장르의 영화를 고르세요.
select koreantitle
from 
	movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
where 
	g.genrekorname = '드라마' or g.genrekorname = '전쟁';
    
-- 18. 톰 행크스가 출연한 영화 중 상영 시간이 가장 긴 영화의 제목, 한글제목, 개봉연도를 출력하세요.
select title, koreantitle, releaseyear
from 
	movie as m join appear as a on a.movieid = m.movieid 
    join role as r on r.roleid = a.roleid
    join person as p on p.personid = a.personid
where 
	rolekorname = '배우' and koreanname = '톰 행크스'
order by runningtime desc limit 1;


-- 19. 아카데미 남우주연상을 가장 많이 수상한 배우를 고르시오
select koreanname
from 
	awardinvolve as ai join appear as a on a.appearid = ai.appearid
    join sector as s on s.sectorid = ai.sectorid 
    join winning as w on w.winningid = ai.winningid
    join person as p on p.personid = a.personid
    join role as r on r.roleid = a.roleid
where
	w.winornot = 'winner' and s.sectorkorname = '남우주연상'  and r.rolekorname = '배우'
group by koreanname
order by count(*) desc limit 1;


-- 20. 아카데미상을 가장 많이 수상한 영화인을 고르시오 ('수상자 없음'이 이름인 영화인은 제외합니다)
select koreanname
from 
	awardinvolve as ai join appear as a on a.appearid = ai.appearid
    join sector as s on s.sectorid = ai.sectorid 
    join winning as w on w.winningid = ai.winningid
    join person as p on p.personid = a.personid
    join role as r on r.roleid = a.roleid
where
	w.winornot = 'winner' and koreanname <> '수상자 없음' and rolekorname= '배우'
group by koreanname
order by count(*) desc limit 1;

-- 21. 아카데미 남우주연상을 2번 이상 수상한 배우를 고르시오
select koreanname
from 
	awardinvolve as ai join appear as a on a.appearid = ai.appearid
    join sector as s on s.sectorid = ai.sectorid 
    join winning as w on w.winningid = ai.winningid
    join person as p on p.personid = a.personid
    join role as r on r.roleid = a.roleid
where
	w.winornot = 'winner' and s.sectorkorname = '남우주연상'  and r.rolekorname = '배우'
group by koreanname
having count(*) >=2;


-- 23. 아카데미상을 가장 많이 수상한 사람을 고르세요.
select koreanname
from 
	awardinvolve as ai join appear as a on a.appearid = ai.appearid
    join sector as s on s.sectorid = ai.sectorid 
    join winning as w on w.winningid = ai.winningid
    join person as p on p.personid = a.personid
    join role as r on r.roleid = a.roleid
where
	w.winornot = 'winner' and koreanname <> '수상자 없음'
group by koreanname
order by count(*) desc limit 1;



-- 24. 아카데미상에 가장 많이 노미네이트 된 영화를 고르세요.

select koreantitle
from 
	awardinvolve as ai join appear as a on a.appearid = ai.appearid
    join movie as m on a.movieid = m.movieid
    join ay on ai.awardyearid = ay.awardyearid
    join award aw on aw.awardid = ay.awardid
    join winning as w on ai.winningid = w.winningid
where 
	winornot = 'nominated' 
group by movieid
order by count(*) desc limit 1;


-- 25. 가장 많은 영화에 출연한 여배우를 고르세요.
select koreanname
from 
	appear as a join person p on a.personId = p.personId
	join movie m on a.movieId = m.movieId
	join role r on r.RoleID = a.RoleId
where r.roleName = "actress"
group by p.personId
order by count(*) desc limit 1;


-- 26. 수익이 가장 높은 영화 TOP 10을 출력하세요.
select title
from movie
order by boxofficewwgross limit 10;

-- 27. 수익이 10억불 이상인 영화중 제작비가 1억불 이하인 영화를 고르시오.
select title 
from movie
where boxofficewwgross >= 1000000000 and budget <= 100000000;

-- 28. 전쟁 영화를 가장 많이 감독한 사람을 고르세요.
select name
from 
	movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
    join appear as a on a.movieid = m.movieid
    join person as p on a.personid = p.personid
    join role as r on r.roleid = a.roleid
where 
	genrekorname = '전쟁' and rolekorname = '감독'
group by name
order by count(*) desc limit 1;
    
-- 29. 드라마에 가장 많이 출연한 사람을 고르세요.
select name
from 
movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
    join appear as a on a.movieid = m.movieid
    join person as p on a.personid = p.personid
    join role as r on r.roleid = a.roleid
where 
	genrekorname = '드라마' and rolekorname = '배우'
group by name
order by count(*) desc limit 1;

-- 30. 드라마 장르에 출연했지만 호러 영화에 한번도 출연하지 않은 사람을 고르세요.
select name
from
movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
    join appear as a on a.movieid = m.movieid
    join person as p on a.personid = p.personid
    join role as r on r.roleid = a.roleid
where
	genrekorname = '드라마' and rolekorname ='배우' and
	genrekorname not in(genrekorname='호러');

-- 31. 아카데미 영화제가 가장 많이 열린 장소는 어디인가요?
select location
from 
	award a join awardyear ay on a.awardid = ay.awardid
group by location
order by count(location) desc limit 1;
    
-- 33. 첫 번째 아카데미 영화제가 열린지 올해 기준으로 몇년이 지났나요?
select 2023 - min(year) 
from 
	award a join awardyear ay on a.awardid = ay.awardid;


-- 34. 아카데미에 가장 많이 노미네이트된 사람은 누구인가요?
select name
from 
	awardinvolve ai join appear a on a.appearid = ai.appearid
    join person p on p.personid = a.personid
    join winning w on w.winningid = ai.winningid
where winornot = 'nominated'
group by name 
order by count(winornot) desc limit 1;


-- 35. 1999년에서 2009년 사이에 남우 주연상을 수상한 배우를 모두 고르세요.
select name
from 
	awardinvolve ai join sector s on s.sectorid = ai.sectorid
    join awardyear ay on ay.awardyearid = ai.awardyearid 
    join appear a on a.appearid = ai.appearid
    join person p on p.personid = a.personid
    join role r on r.roleid = a.roleid
    join winning w on w.winningid = ai.winningid
where 
	(year between 1999 and 2009) and rolekorname = '배우' and sectorkorname = '남우주연상'
    and winornot = 'winner';

-- 36. 아카데미를 한번 수상한 후, 가장 짧은 기간에 한번 더 수상한 사람을 고르세요.
select *
from
	awardinvolve ai join sector s on s.sectorid = ai.sectorid
    join awardyear ay on ay.awardyearid = ai.awardyearid 
    join appear a on a.appearid = ai.appearid
    join person p on p.personid = a.personid
    join role r on r.roleid = a.roleid
    join winning w on w.winningid = ai.winningid
where 
	winornot = 'winner';

-- 37. '제임스 카메론'의 영화에 출연한 모든 배우를 고르세요
select name
from 
	role r join appear a on r.roleid = a.roleid
    join person p on p.personid = a.personid 
    join movie m on a.movieid = a.movieid
where rolekorname = '배우' and title in 
( select title
from 
	role r join appear a on r.roleid = a.roleid
    join person p on p.personid = a.personid 
    join movie m on a.movieid = a.movieid	
where koreanname='제임스 카메론'
);

-- 38. '월드 디즈니'가 수상한 아카데미상의 종류를 고르세요
select distinct sectorname
from 
	sector s join awardinvolve ai on s.sectorid = ai.sectorid
    join winning w on w.winningid = ai.winningid
    join appear a on a.appearid = ai.appearid
    join person p on p.personid = a.personid
where
	koreanname = '월트 디즈니' and winornot = 'winner';
    
    
-- 39. 장르별 영화의 제작비 평균을 구하세요.
select avg(budget), genrename
from 
	movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
    join appear as a on a.movieid = m.movieid
group by genrename;
	

-- 40. 장르별 영화의 제작비 대비 수익률을 구하세요. 
select sum(boxofficewwgross/ budget)*100, genrename
from 	
	movie as m join moviegenre as mg on mg.movieid = m.movieid
    join genre as g on g.genreid = mg.genreid
    join appear as a on a.movieid = m.movieid
group by genrename;
