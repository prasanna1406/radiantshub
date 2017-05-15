--Roles entry--
INSERT INTO roles (id,role_name,created_date) values(1,'ADMIN',NOW());
INSERT INTO roles (id,role_name,created_date) values(2,'VEHICLE_OWNER',NOW());
INSERT INTO roles (id,role_name,created_date) values(3,'DRIVER',NOW());

--Admin user entry--

insert into user values (1 , NOW(), 'developer2@perennialsys.com' , NULL , 0, NOW(), NOW(), 'Admin', NULL, '8krQ8AZGCi2EcOV1Qw5LNQ==', NULL, NULL, 'active', NULL, 1);
