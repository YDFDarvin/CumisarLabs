create table remedy_category (id int8 not null, description varchar(255), name varchar(255), primary key (id));
alter table if exists remedy add constraint remedy_category_fk foreign key (category_id) references remedy_category;