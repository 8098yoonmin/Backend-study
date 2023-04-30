
use academic_management;

drop table if exists student;
drop table if exists lecture;
drop table if exists professor;

drop table if exists department;
drop table if exists place;
drop table if exists subject;
drop table if exists register;


create table place(
	placename varchar(30),
    location varchar(20) primary key
);


create table professor (
	professorid int not null,
    professorname varchar(10) not null,
    professormajor varchar(30) not null,
    email varchar(30),
    phone varchar(20),
    address varchar(50),
    laboratory varchar(20),
    primary key(professorid, laboratory),
   constraint fk_laboratory foreign key(laboratory) references place(location)
);

create table department(
	departmentid int,
    departmentname varchar(40),
    major varchar(40) unique,
    majorplace varchar(40),
    primary key(departmentid, majorplace),
    constraint fk_majorplace foreign key(majorplace) references place(location)
);

create table subject(
	subjectid int ,
    subjectname varchar(20),
    primary key(subjectid, subjectname)
);

create table lecture(
	lectureid int primary key,
    lecturename varchar(20),
    credit int,
	lectureplace varchar(30),
    lecture_proid int,
    foreign key(lecture_proid) references professor(professorid),
    foreign key(lectureplace) references place(location),
    foreign key(lectureid, lecturename) references subject(subjectid, subjectname)
);



create table student (
	studentid int not null primary key,
    studentname varchar(10) not null,
    studentmajor varchar(30) not null,
    gender varchar(10) not null,
    guardian varchar(10),
    nativepalce varchar(20),
    advisor int,
    phone varchar(20), 
    email varchar(30),
	birthyear int,
    birthplace varchar(40),
    foreign key (advisor) references professor(professorid),
    foreign key (studentmajor) references department(major)
);


create table class (
	grade varchar(10),
    classid int primary key,
    studentid int,
    attendance int,
    foreign key(classid) references lecture(lectureid),
    foreign key(studentid) references student(studentid)
);





    
    