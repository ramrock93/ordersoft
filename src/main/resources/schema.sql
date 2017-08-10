create table if not exists address_table 
(
	id bigint generated by default as identity, 
	country varchar(255), 
	number integer, 
	street varchar(255), 
	town varchar(255), 
	zip_code varchar(255), 
	customer_id bigint, 
	primary key (id)
);
 
create table if not exists customer_table
(
	id bigint generated by default as identity, 
	email varchar(255), 
	name varchar(255), 
	phone integer, 
	primary key (id)
);

create table if not exists customer_table_current_address 
(
	customer_id bigint not null, 
	current_address_id bigint not null
);

create table if not exists customer_table_orders 
(
	customer_id bigint not null, 
	orders_order_id bigint not null
);

create table if not exists order_table 
(
	order_id bigint generated by default as identity, 
	date binary(255), 
	description varchar(255), 
	customer_id bigint, moving_to_id bigint, 
	primary key (order_id)
);

create table if not exists order_table_services 
(
	order_order_id bigint not null, 
	services_id bigint not null
);

create table if not exists service_table 
(	
	id bigint generated by default as identity, 
	service_type integer, 
	order_order_id bigint, 
	primary key (id)
);