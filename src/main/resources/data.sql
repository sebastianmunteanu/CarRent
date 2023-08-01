insert into t_customer(firstName, lastName, phoneNumber, email)
values ('Popescu', 'Ion', '07399999999', 'test@test');

insert into t_customer(firstName, lastName, phoneNumber, email)
values ('Grigore', 'Marius', '07399999999', 'test2@test');

insert into t_customer(firstName, lastName, phoneNumber, email)
values ('Vlad', 'Andrei', '07399999999', 'test3@test');

insert into t_customer(firstName, lastName, phoneNumber, email)
values ('Miron', 'Ana', '07399999999', 'test4@test');

insert into t_car(brand, model, yearOfManufacture, color, mileage)
values ('Audi', 'A4', 2001, 'rosu', 22.6);

insert into t_car(brand, model, yearOfManufacture, color, mileage)
values ('BMW', 'X5', 2022, 'negru', 100);

insert into t_car(brand, model, yearOfManufacture, color, mileage)
values ('Opel', 'Insignia', 2017, 'verge', 10390);

insert into t_role(roleName)
values ('ROLE_ADMIN');

insert into t_role(roleName)
values ('ROLE_USER');

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-22', 2, 2);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-23', '2023-07-31', '2023-07-22', 1, 2);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-24', 2, 3);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-24', 4, 1);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-22', 4, 3);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-31', '2023-07-31', '2023-07-27', 4, 2);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-27', 2, 2);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-27', 3, 3);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-22', '2023-07-31', '2023-07-30', 1, 2);

insert into t_reservation(startDate, endDate, dateOfReservation, customerId, carId)
values ('2023-07-10', '2023-07-31', '2023-07-18', 2, 1);