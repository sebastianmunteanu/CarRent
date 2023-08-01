create table t_customer
(
    id  integer auto_increment,
    firstname varchar(50),
    lastname varchar(50),
    phonenumber varchar(50),
    email varchar(120),
    primary key (id)
);

create table t_car
(
    id  integer auto_increment,
    brand varchar(50),
    model varchar(50),
    yearofmanufacture integer,
    color varchar(50),
    mileage double precision,
    primary key (id)
);


create table t_role
(
    id integer auto_increment,
    roleName varchar(50),
    primary key (id)
);


create table t_reservation
(
    id integer auto_increment,
    startDate DATE,
    endDate DATE,
    dateOfReservation DATE,
    customerId integer,
    carId integer,
    primary key (id)
);