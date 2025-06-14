create database store;

CREATE TABLE users(
id bigint primary key not null auto_increment,
name varchar(255) not null,
email varchar(255) not null,
password varchar(255) not null
);

CREATE TABLE addresses(
id bigint primary key not null auto_increment,
country varchar(255) not null,
city varchar(255) not null,
street varchar(255),
zip varchar(255),
user_id bigint not null,
foreign key (user_id) references users(id)
);

<!--  Modifier la clé étrangère user_id sur on delete cascade -->

<!-- alter table addresses drop constraint `addresses_ibfk_1`; SUPPRIMER CETTE CONTRAINTE SI ELLE EXISTE -->
alter table addresses add constraint `addresses_ibfk_2`
FOREIGN KEY (user_id) REFERENCES users (id) on delete cascade;

CREATE TABLE profiles(
id bigint primary key not null auto_increment,
bio text,
phone_number varchar(15),
date_of_birth date,
loyalty_points int unsigned default 0,
user_id bigint not null,
foreign key (user_id) references users(id)
);

CREATE TABLE tags(
id bigint primary key not null auto_increment,
name varchar(255) not null
);

create table user_tags(
user_id bigint not null,
tag_id bigint not null,
primary key (user_id, tag_id),
foreign key (user_id) references users (id) on delete cascade,
foreign key (tag_id) references tags (id) on delete cascade
);

create table category(
id bigint not null primary key auto_increment,
name varchar(255) not null
);

create table product(
id bigint not null primary key auto_increment,
name varchar(255) not null,
price double default 0.0,
category_id bigint not null,
foreign key (category_id) references category (id) on delete cascade
);

create table wishlist(
user_id bigint not null,
product_id bigint not null,
primary key (user_id, product_id),
foreign key (user_id) references users(id) on delete cascade,
foreign key (product_id) references product(id) on delete cascade
);