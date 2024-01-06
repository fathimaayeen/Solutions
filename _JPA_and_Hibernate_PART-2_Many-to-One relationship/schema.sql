

create table if not exists publisher (
  publisherId INT PRIMARY KEY AUTO_INCREMENT,
  publisherName varchar(255)
);

 create table book (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name varchar(255),
   imageUrl varchar(255),
   publisherId INT,
   FOREIGN KEY (publisherId) REFERENCES publisher(publisherId)
 );
