CREATE TABLE IF NOT EXISTS `Users` (
    `user_id`   VARCHAR(50) NOT NULL,
    `password`  VARCHAR(50) NOT NULL,

    PRIMARY KEY(`user_id`)
);

MERGE INTO `Users` KEY ( `user_id` ) VALUES ( 'admin', '12345' );
MERGE INTO `Users` KEY ( `user_id` ) VALUES ( 'dongmyo', '67890' );

create table if not exists `Items` (
    `item_id` bigint not null auto_increment,
    `item_name` varchar(40) not null,
    `price` bigint not null,

    primary key(`item_id`)
);

create table if not exists `Orders` (
    `order_id` bigint not null auto_increment,
    `order_date` timestamp not null,

    primary key(`order_id`)
);

create table if not exists `OrderItems` (
    `order_id` bigint not null,
    `line_number` integer not null,
    `item_id` bigint not null,
    `quantity` integer not null,

    primary key(`order_id`, `line_number`)
);

merge into `Items` key (`item_id`) values (  1, 'apple',  300 );
merge into `Items` key (`item_id`) values (  2, 'grape',  200 );
merge into `Items` key (`item_id`) values (  3, 'banana', 150 );
merge into `Items` key (`item_id`) values (  4, 'cherry', 250 );
merge into `Items` key (`item_id`) values (  5, 'kiwi',   400 );
merge into `Items` key (`item_id`) values (  6, 'lemon',  250 );
merge into `Items` key (`item_id`) values (  7, 'lime',   250 );
merge into `Items` key (`item_id`) values (  8, 'mango',  350 );
merge into `Items` key (`item_id`) values (  9, 'orange', 200 );
merge into `Items` key (`item_id`) values ( 10, 'peach',  300 );
merge into `Items` key (`item_id`) values ( 11, 'melon',  100 );

merge into `Orders` key (`order_id`) values ( 1001, '2018-08-23 10:30:00' );
merge into `Orders` key (`order_id`) values ( 1002, '2018-08-24 21:15:30' );

merge into `OrderItems` key (`order_id`, `line_number`) values ( 1001, 1, 1, 3 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1001, 2, 2, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1001, 3, 3, 2 );

merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 1, 4, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 2, 5, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 3, 6, 2 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 4, 7, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 5, 8, 5 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 6, 9, 1 );

drop table if exists `Members`;
drop table if exists `Lockers`;

create table if not exists `Members` (
    `member_id` varchar(255) not null,
    `user_name` varchar(255),

    primary key (`member_id`)
);

create table if not exists `Lockers` (
    `locker_id` bigint not null,
    `member_id` varchar(255) not null,
    `locker_name` varchar(50),

    primary key (`locker_id`)
);

create table if not exists `Boards` (
    `board_id` bigint not null,
    `title` varchar(50) not null,

    primary key (`board_id`)
);

create table if not exists `BoardDetails` (
    `board_id` bigint not null,
    `content` varchar(255),

    primary key (`board_id`)
);

drop table if exists `MemberDetails`;

create table if not exists `MemberDetails` (
    `member_detail_id` bigint not null,
    `member_id` varchar(255) null,
    `type` varchar(45) not null,
    `description` varchar(255),

    primary key (`member_detail_id`)
);

/* TODO #1: 테이블 생성 쿼리 */
create table if not exists `Students` (
  `student_id` bigint not null,
  `student_name` varchar(255) not null,

  primary key (`student_id`)
);

create table if not exists `Classes` (
  `class_id` bigint not null,
  `class_name` varchar(255) not null,

  primary key (`class_id`)
);

create table if not exists `Enrollments` (
  `student_id` bigint not null,
  `class_id` bigint not null,
  `enrolled_at` datetime,

  primary key (`student_id`, `class_id`)
);

merge into `Students` key (`student_id`) values ( 1, 'chosun' );
merge into `Students` key (`student_id`) values ( 2, 'nhn' );

merge into `Classes` key (`class_id`) values ( 100, 'servlet' );
merge into `Classes` key (`class_id`) values ( 200, 'jpa' );
merge into `Classes` key (`class_id`) values ( 300, 'auth' );

merge into `Enrollments` key (`student_id`,`class_id`) values ( 1, 100, now() );
merge into `Enrollments` key (`student_id`,`class_id`) values ( 1, 200, now() );

merge into `Enrollments` key (`student_id`,`class_id`) values ( 2, 100, now() );
merge into `Enrollments` key (`student_id`,`class_id`) values ( 2, 200, now() );
merge into `Enrollments` key (`student_id`,`class_id`) values ( 2, 300, now() );
