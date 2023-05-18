CREATE TABLE IF NOT EXISTS `Members` (
    `member_id`   VARCHAR(50)  NOT NULL,
    `name`        VARCHAR(50)  NOT NULL,
    `pwd`         VARCHAR(100) NOT NULL,

    PRIMARY KEY(`member_id`)
);

merge into Members key(member_id) values('admin', '관리자', '1234');

CREATE TABLE IF NOT EXISTS `Authoroties` (
    `member_id`   VARCHAR(50)  NOT NULL,
    `authority`   VARCHAR(50)  NOT NULL,

    PRIMARY KEY(`member_id`)
);

