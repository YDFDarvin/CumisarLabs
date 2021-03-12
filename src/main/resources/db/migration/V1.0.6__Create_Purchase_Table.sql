create table purchase (id int8 not null, customer_id int8, pharmacist_id int8, pharmacy_id int8, remedy_id int8, primary key (id));
alter table if exists purchase add constraint purchase_customer_fk foreign key (customer_id) references customer;
alter table if exists purchase add constraint purchase_pharmacist_fk foreign key (pharmacist_id) references pharmacist;
alter table if exists purchase add constraint purchase_pharmacy_fk foreign key (pharmacy_id) references pharmacy;
alter table if exists purchase add constraint purchase_remedy_fk foreign key (remedy_id) references remedy;