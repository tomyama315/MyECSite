set names utf8;
set foreign_key_checks=0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insertbyid varchar(10),
root int(1),
insert_date datetime,
update_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
item_comment varchar(255),
insertbyid varchar(10),
insert_date datetime,
update_date datetime,
image_path varchar(255),
image_name varchar(255)
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insertbyid varchar(10),
insert_date datetime,
delete_date datetime
);

drop table if exists SupplierHistory;
create table SupplierHistory(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insertbyid varchar(10),
insert_date datetime,
delete_date datetime,
item_name varchar(30),
done int(1)
);

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_comment,insertbyid,insert_date,update_date,image_path,image_name) VALUES("ノートBook",100,50,"default","default",cast(now()as datetime),cast(now()as datetime),"default","images/notebook.jpg");
INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_comment,insertbyid,insert_date,update_date,image_path,image_name) VALUES("Cockroach",100000,2000,"default","default",cast(now()as datetime),cast(now()as datetime),"default","images/cockroach.jpg");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,root) VALUES("internous","internous01","test",1);