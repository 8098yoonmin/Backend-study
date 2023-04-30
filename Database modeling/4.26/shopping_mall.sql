CREATE TABLE IF NOT EXISTS `mydb`.`grade` (
  `gradeid` INT NOT NULL,
  `gradename` VARCHAR(45) NULL,
  PRIMARY KEY (`gradeid`));


CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `userid` INT NOT NULL,
  `userpw` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `useremail` VARCHAR(45) NULL,
  `userphone` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `grade_gradeid` INT NOT NULL,
  PRIMARY KEY (`userid`),
  INDEX `fk_users_grade1_idx` (`grade_gradeid` ASC) VISIBLE,
  CONSTRAINT `fk_users_grade1`
    FOREIGN KEY (`grade_gradeid`)
    REFERENCES `mydb`.`grade` (`gradeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`product_category` (
  `product_clf_id` INT NOT NULL,
  `product_clf_name` VARCHAR(30) NULL,
  `clf_details` VARCHAR(45) NULL,
  `product_categorycol` VARCHAR(45) NULL,
  `product_category_product_clf_id` INT NOT NULL,
  PRIMARY KEY (`product_clf_id`),
  INDEX `fk_product_category_product_category1_idx` (`product_category_product_clf_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_category_product_category1`
    FOREIGN KEY (`product_category_product_clf_id`)
    REFERENCES `mydb`.`product_category` (`product_clf_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `product_id` INT NOT NULL,
  `sub_productclf_id` INT NULL,
  `product_name` VARCHAR(45) NULL,
  `product_price` INT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `fk_product_product_category1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product_category` (`product_clf_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`review` (
  `review_id` INT NOT NULL,
  `review_date` DATETIME NULL,
  `star` INT NULL,
  `productid` VARCHAR(45) NULL,
  `review_content` VARCHAR(45) NULL,
  `review_file` VARCHAR(45) NULL,
  `reviewer_id` INT NOT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `fk_review_users1_idx` (`reviewer_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_users1`
    FOREIGN KEY (`reviewer_id`)
    REFERENCES `mydb`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`file` (
  `fileid` INT NOT NULL,
  `file_name` VARCHAR(300) NULL,
  `review_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`fileid`),
  INDEX `fk_file_review1_idx` (`review_id` ASC) VISIBLE,
  INDEX `fk_file_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_file_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `mydb`.`review` (`review_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_file_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `mydb`.`inquiry` (
  `inquiry_id` INT NOT NULL,
  `inquiry_user_id` INT NULL,
  `inquiry_category` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `content` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `inquirycol` VARCHAR(45) NULL,
  `answer` TINYINT NULL,
  PRIMARY KEY (`inquiry_id`),
  INDEX `fk_inquiry_users1_idx` (`inquiry_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_inquiry_users1`
    FOREIGN KEY (`inquiry_user_id`)
    REFERENCES `mydb`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `mydb`.`notice` (
  `noticeid` INT NOT NULL,
  `noticetitle` VARCHAR(45) NULL,
  `noticecontent` VARCHAR(45) NULL,
  `notice_date` DATETIME NULL,
  `notice_writer` INT NOT NULL,
  PRIMARY KEY (`noticeid`),
  INDEX `fk_notice_users1_idx` (`notice_writer` ASC) VISIBLE,
  CONSTRAINT `fk_notice_users1`
    FOREIGN KEY (`notice_writer`)
    REFERENCES `mydb`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`cart` (
  `cart_id` INT NOT NULL,
  `cart_user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `wishornot` TINYINT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `fk_cart_users1_idx` (`cart_user_id` ASC) VISIBLE,
  INDEX `fk_cart_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_users1`
    FOREIGN KEY (`cart_user_id`)
    REFERENCES `mydb`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `mydb`.`nonuser_order` (
  `order_id` INT NOT NULL,
  `order_date` DATETIME NULL,
  `receiver_phone` VARCHAR(45) NULL,
  `receiver_email` VARCHAR(45) NULL,
  `nonuser_address` VARCHAR(45) NULL,
  PRIMARY KEY (`order_id`));


CREATE TABLE IF NOT EXISTS `mydb`.`deliver_address` (
  `userid` INT NOT NULL,
  `user_address` VARCHAR(45) NULL,
  INDEX `fk_deliver_address_users1_idx` (`userid` ASC) VISIBLE,
  PRIMARY KEY (`userid`),
  CONSTRAINT `fk_deliver_address_users1`
    FOREIGN KEY (`userid`)
    REFERENCES `mydb`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `mydb`.`user_order` (
  `order_id` INT NOT NULL,
  `order_userid` INT NOT NULL,
  `user_ordercol` VARCHAR(45) NULL,
  `order_date` DATETIME NULL,
  `user_address` VARCHAR(45) NULL,
  `nonuser_order_order_id` INT NOT NULL,
  `deliver_address_userid` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_user_order_users1_idx` (`order_userid` ASC) VISIBLE,
  INDEX `fk_user_order_nonuser_order1_idx` (`nonuser_order_order_id` ASC) VISIBLE,
  INDEX `fk_user_order_deliver_address1_idx` (`deliver_address_userid` ASC) VISIBLE,
  CONSTRAINT `fk_user_order_users1`
    FOREIGN KEY (`order_userid`)
    REFERENCES `mydb`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_order_nonuser_order1`
    FOREIGN KEY (`nonuser_order_order_id`)
    REFERENCES `mydb`.`nonuser_order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_order_deliver_address1`
    FOREIGN KEY (`deliver_address_userid`)
    REFERENCES `mydb`.`deliver_address` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`user_order_detail` (
  `order_detail_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `product_quantity` INT NULL,
  PRIMARY KEY (`order_detail_id`),
  INDEX `fk_user_order_detail_user_order1_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_user_order_detail_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_order_detail_user_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `mydb`.`user_order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_order_detail_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
CREATE TABLE IF NOT EXISTS `mydb`.`nonuser_order_detail` (
  `order_detail_id` INT NOT NULL,
  `nonuser_order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `product_quantity` INT NULL,
  PRIMARY KEY (`order_detail_id`),
  INDEX `fk_nonuser_order_detail_nonuser_order1_idx` (`nonuser_order_id` ASC) VISIBLE,
  INDEX `fk_nonuser_order_detail_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_nonuser_order_detail_nonuser_order1`
    FOREIGN KEY (`nonuser_order_id`)
    REFERENCES `mydb`.`nonuser_order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nonuser_order_detail_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);