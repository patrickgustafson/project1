create table stock (
	warehouse_id INT REFERENCES warehouses(warehouse_id) on delete cascade,
 	item_id INT REFERENCES items(item_id) on delete cascade,
  	quantity INT not null,
  PRIMARY KEY (warehouse_id, item_id)
);

create table warehouses (
	warehouse_id serial primary key,
	location text not null,
	capacity int not null
);

create table items (
	item_id serial primary key,
	name text not null,
	units int not null
);