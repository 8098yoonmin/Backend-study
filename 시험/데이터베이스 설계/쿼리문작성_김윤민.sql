use exam_8;

-- 데이터 삽입 
insert into address values ( 1, "녹address스빌,테네시,미국");
insert into address values ( 2, "디켈브,일리노이,미국");
insert into address values ( 3, "할리우드,로스앵ㄴ젤레스,캘리포니아,미국");

insert into person values
    ('쿠엔틴 타란티노', 'quentin jerome tarantino', '1963-03-27', '쿠엔틴 제롬 타란티노는 간호사인 어머니와 뉴욕출신인 이탈리아계 미국인 아버지 사이에서 태어났다. 타란티노는 네 살때 어머니와 함께 캘리포니아 토렌스로 이사했다.',
    1,1);
insert into person values
	('레오나르도 디카프리오', 'Leonardo Wilhelm DiCaprio', '1974-11-11',
    'Few actors in the world have had a career quite as diverse as Leonardo DiCaprio‘s. DiCaprio has gone from relatively humble beginnings, as a supporting',
    2, 3);
insert into person values
	('리처드 젠킨스', null, '1947-04-04', 'Richard Jenkins was born on May 4, 1947 in DeKalb, Illinois, USA. He is an actor, known for Jack Reacher (2012), The Cabin in the Woods (2012) and Step Brothers (2008).',
    3,2);

insert into genre values
(1, '코미디');
insert into genre values
(2, '드라마');

insert into age values
(1, 12);
insert into age values
(2, 15);

insert into boxoffice values
(9000000, 140919587, 371544347, 1);
insert into boxoffice values
(8000000, null, null, 2);
insert into boxoffice values
(45000000, 22195105, 30695105, 3);

insert into movie values
(1, '원스 어폰 어 타임...인 할리우드', 161, '2019-09-25', 
'브래드피트는 ~~대사를 만들었다.', 
'쇠락해 가는 TV 스타 릭 달톤과 그의 친구인 스턴트 클리프 부스는 1969년 할리우드 황금기의 마지막 몇 년동안 영화 산업에서 명성을 쌓고 성공하기 위해 노력한다.',
1, 1, 1);
insert into movie values
(2, '돈룩업', 138, '2021-08-12', '제니퍼 로렌스는 촬영 중 치아가 부러졌으나 코로나 19로 인해 치과에 갈 수 없었고, 대부분의 장면을 치아가 부러진 채로 촬영했다.',
'천문학과 대학원생 케이트 디비아스키와 담당 교수 랜들 민디 박사는 태양계 내의 궤도를 돌고 있는 혜성이 지구와 직접 충돌하는 궤도에 들어섰다는 엄청난 사실을 발견한다.',
2, 2, 2);
insert into movie values
(3, '리처드 주얼', 131, '2019-02-02', null, 'American security guard Richard Jewell saves thousands of lives from an exploding bomb at the 1996 Olympics, but is vilified by journalists and the press who falsely reported that he was a terrorist.'
, 1, 2, 3);


insert into article values
	(1, '할리우드 두 남자의 애잔한 삶', 1);

insert into article values
	(2, '<리처드 주얼>에서 클린트 이슽트우드가 손을 다루는 방법', 3);
    
insert into award values
	(2020, null, 1, 1, '아카데미 영화제');
insert into award values
	(2022, null, 2, 2, '아카데미 영화제'),
    (2020, null, 1, 2, '아카데미 영화제');

insert into occupation values
	(1, '감독'),
    (2, '배우'),
    (3, '제작'),
    (4, '각본');

insert into role values
	(1, 1, 1, 2),
    (2, 1, 1, 1),
    (3, 1, 1, 3),
    (4, 1, 1, 4);

insert into role values
	(5, 1, 2, 2),
    (6, 2, 2, 2);

-- 쿠엔틴 타란티노의 정보가 표시되는 것을 확인합니다.
select *
from person as p 
    join role as r on r.person_id = p.person_id
where p.person_name='쿠엔틴 타란티노';
-- (occupation_id : 1-감독, 2-배우, 3-제작, 4-각본) 
   

-- '원스 어폰 어 타임 인... 할리우드' 영화 정보가 표시되는 것을 확인합니다.
select *
from movie as m join role as r on r.movie_id = m.movie_id
	join award as a on a.movie_id = m.movie_id
    join article as ac on ac.movie_id = m.movie_id
where m.movie_title = '원스 어폰 어 타임...인 할리우드';

	    

-- 첫 번째 배우 '레오나르도 디카프리오' 정보가 표시되는 것을 확인합니다.
select *
from person as p join role as r on r.person_id = p.person_id
where p.person_name = '레오나르도 디카프리오';

-- '레오나르도 디카프리오'의 아카데미 수상 정보를 확인합니다.
select *
from person as p join award as a on a.person_id = p.person_id
where p.person_name = '레오나르도 디카프리오';


-- 오른쪽 위의 검색 창에 '리처드'를 입력한 후 검색 결과를 확인합니다.
select *
from person as p
where p.person_name= '리처드 젠킨스';
select *
from movie as m
where m.movie_title='리처드 주얼';

