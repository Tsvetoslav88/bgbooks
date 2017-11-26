CREATE TABLE BOOK (
  name varchar(200) NOT NULL,
  author varchar(100) NOT NULL,
  type varchar(400),
  UNIQUE KEY `UK_book` (`name`, `author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
