create table room(
    id serial PRIMARY KEY,
    room_id int,
    FOREIGN KEY(room_id) REFERENCES room(id)
);
create table IF NOT EXISTS animal(
    id serial  PRIMARY KEY ,
    name varchar(50),
    favouriteFood varchar(50),
    age smallint,
    entryDate timestamp,
    weight varchar(10),
    height varchar(10),
    tail_length varchar(10),
    wingspan varchar(10),
    room_id int,
    FOREIGN KEY(room_id) REFERENCES room(id)
);
create table IF NOT EXISTS bag(
    id serial primary key,
    max_slots smallint,
    available_slots smallint
);
create table IF NOT EXISTS item(
    id serial primary key ,
    name varchar(50),
    description varchar(50),
    required_slots smallint,
    room_id int,
    bag_id int,
    foreign key (room_id) references room(id),
    foreign key (bag_id) references bag(id)
);
create table IF NOT EXISTS player(
    id serial primary key ,
    name varchar(50) ,
    life_points smallint,
    bag_id int,
    FOREIGN KEY(bag_id) REFERENCES bag(id)
);

create table IF NOT EXISTS linked_rooms(
    direction varchar(10) ,
    room_id int,
    linked_room_id int,
    PRIMARY KEY (direction,room_id),
    foreign key (room_id) references room(id),
    foreign key (linked_room_id) references room(id)
);
