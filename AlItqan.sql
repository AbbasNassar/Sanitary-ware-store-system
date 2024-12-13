create database AlItqan;
use AlItqan;


-- Create Department table
CREATE TABLE department (
    Did INT PRIMARY KEY,
    name VARCHAR(32),
    numberOfEmployees INT,
    Eid int

);


-- Create Warehouses table
CREATE TABLE warehouses (
    Wid INT PRIMARY KEY,
    capacity INT,
    location VARCHAR(32),
    numberOfEmployees INT
);

-- Create Employee table
CREATE TABLE employee (
    Eid INT PRIMARY KEY,
    name VARCHAR(32),
    address VARCHAR(32),
    salary INT,
    jobType VARCHAR(32),
    Did INT,
    Wid INT,
    pass varbinary(32),
    FOREIGN KEY (Did) REFERENCES department(Did) on update cascade on delete cascade,
	FOREIGN KEY (Wid) REFERENCES warehouses(Wid) on update cascade on delete cascade

);

alter table department add foreign key (Eid) references employee (Eid) on update cascade on delete cascade;


create table Employeephone (
 Eid int,
 phoneNumber varchar (16),
 primary key (Eid,phoneNumber),
 foreign key (Eid) references employee(Eid) on delete cascade on update cascade
);



-- Create Vehicles table
CREATE TABLE vehicles (
    Vid INT PRIMARY KEY,
    model VARCHAR(32),
    yearOfProduction INT,
    capacity INT,
    numberOfOrders INT,
    licensePlateNumber VARCHAR(32),
    licenseExpiryDate DATE,
    Eid INT,
    FOREIGN KEY (Eid) REFERENCES employee(Eid) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create Client table
create table client (
cid int primary key unique auto_increment ,
name varchar(32),
address varchar (32),
payment_method varchar (32)
);

create table Clientphone (
 cid int,
 phoneNumber varchar (16),
  primary key (cid,phoneNumber),
 foreign key (cid) references client(cid) on delete cascade on update cascade
);

-- Create Products table
CREATE TABLE products (
    Pid INT PRIMARY KEY,
    Pname VARCHAR(32),
    price REAL,
    quantity real
);

-- Create Sales Order table
CREATE TABLE salesOrder (
    SOid INT PRIMARY KEY auto_increment,
    date DATE,
    discount real,
    totalPrice real,
    Cid INT,
	Paytype varchar(20),
    paidamount real,
    remaining real, 
    FOREIGN KEY (Cid) REFERENCES client(cid) on update cascade on delete cascade
);

create table deliveryOrder (
   Orderid Int,
   Driverid Int,
   Carid Int,
   Orderstatus varchar (20),
   OrderDistenation varchar (20),
   foreign key (Orderid) references salesOrder(SOid) on update cascade on delete cascade,
   foreign key (Driverid) references Employee(Eid) on update cascade on delete cascade,
   foreign key (Carid) references vehicles(Vid) on update cascade on delete cascade
);

create table inplaceorder (
   Orderid Int,
   Empid Int,
   foreign key (Orderid) references salesOrder(SOid),
   foreign key (Empid) references Employee(Eid)
);

-- Create Suppliers table
CREATE TABLE suppliers (
    Sid INT PRIMARY KEY,
    name VARCHAR(32),
    address VARCHAR(32)
);


-- Create Purchase Order table
CREATE TABLE purchaseOrder (
    POid INT primary key,
    date DATE,
    totalPrice real,
    discount real,
    Sid INT,
    FOREIGN KEY (Sid) REFERENCES suppliers(Sid) on delete cascade on update cascade

);


CREATE TABLE PorderLines (
    OLid INT auto_increment,
    price INT,
    quantity INT,
    discount REAL,
    Pid INT,
    POId INT,
    primary key (OLid, POId),
    FOREIGN KEY (Pid) REFERENCES products(Pid) on update cascade on delete cascade,
    FOREIGN KEY (POId) REFERENCES purchaseorder(POid)  ON UPDATE CASCADE ON DELETE CASCADE
);


-- Create Order Lines table
CREATE TABLE orderLines (
    OLid INT,
    price INT,
    quantity INT,
    discount REAL,
    Pid INT,
    SOid int,
    primary key (OLid, SoId),
    FOREIGN KEY (Pid) REFERENCES products(Pid) on update cascade on delete cascade,
	FOREIGN KEY (SOId) REFERENCES salesorder(SOid)  on update cascade on delete cascade
);



create table Suppliersphone (
 Sid int,
 phoneNumber varchar (16),
  primary key (Sid,phoneNumber),
 foreign key (Sid) references suppliers(Sid)  -- on delete cascade on update cascade
);


-- Many-to-Many Relationships
-- Employee works for Department
CREATE TABLE work_for (
    Eid INT,
    Did INT,
    PRIMARY KEY (Eid, Did),
    FOREIGN KEY (Eid) REFERENCES employee(Eid),
    FOREIGN KEY (Did) REFERENCES department(Did)
);


-- Employee works at Warehouse
CREATE TABLE work_at (
    Eid INT,
    Wid INT,
    PRIMARY KEY (Eid, Wid),
    FOREIGN KEY (Eid) REFERENCES employee(Eid),
    FOREIGN KEY (Wid) REFERENCES warehouses(Wid)
);

-- Employee drives Vehicles
CREATE TABLE drive (
    Eid INT,
    Vid INT,
    PRIMARY KEY (Eid, Vid),
    FOREIGN KEY (Eid) REFERENCES employee(Eid),
    FOREIGN KEY (Vid) REFERENCES vehicles(Vid)
);



-- Product Subtypes
-- For Metal Products
CREATE TABLE metal_products (
    Pid INT PRIMARY KEY,
    size REAL,
    FOREIGN KEY (Pid) REFERENCES products(Pid)
);

-- For Plastic Products
CREATE TABLE plastic_products (
    Pid INT PRIMARY KEY,
    radius REAL,
    FOREIGN KEY (Pid) REFERENCES products(Pid)
);

-- For Ceramic Products
CREATE TABLE ceramic_products (
    Pid INT PRIMARY KEY,
    length REAL,
    wedith REAL,
    FOREIGN KEY (Pid) REFERENCES products(Pid)
);


-- Insert sample data into Products
INSERT INTO products (Pid, Pname, price, quantity) VALUES
(1, 'Product A', 10.00, 60),
(2, 'Product B', 15.00, 30),
(3, 'Product C', 20.00, 40);

-- Insert sample data into Suppliers
INSERT INTO suppliers (Sid, name, address) VALUES
(1, 'Supplier A', '123 Maple St'),
(2, 'Supplier B', '456 Oak St'),
(3, 'Supplier C', '789 Pine St');

-- Insert sample data into Suppliers
INSERT INTO suppliers (Sid, name, address) VALUES
(4, 'John Smith', 'Maple St'),
(5, 'Jane Doe', 'Oak St'),
(6, 'Michael Brown', 'Pine St'),
(7, 'Emily Davis', 'Birch St'),
(8, 'James Wilson', 'Cedar St'),
(9, 'Mary Johnson', 'Elm St'),
(10, 'Robert Jones', 'Spruce St'),
(11, 'Patricia Garcia', 'Fir St'),
(12, 'Linda Martinez', 'Willow St'),
(13, 'David Lee', 'Poplar St'),
(14, 'Barbara Hernandez', 'Alder St'),
(15, 'Richard Clark', 'Ash St'),
(16, 'Susan Lewis', 'Beech St'),
(17, 'Joseph Walker', 'Hemlock St'),
(18, 'Sarah Hall', 'Juniper St'),
(19, 'Charles Allen', 'Maple St'),
(20, 'Karen Young', 'Oak St');

-- Insert sample data into Suppliersphone
INSERT INTO Suppliersphone (Sid, phoneNumber) VALUES
(4, '555-0001'),
(5, '555-0002'),
(6, '555-0003'),
(7, '555-0004'),
(8, '555-0005'),
(9, '555-0006'),
(10, '555-0007'),
(11, '555-0008'),
(12, '555-0009'),
(13, '555-0010'),
(14, '555-0011'),
(15, '555-0012'),
(16, '555-0013'),
(17, '555-0014'),
(18, '555-0015'),
(19, '555-0016'),
(20, '555-0017');

-- Optionally, add additional phone numbers for some suppliers
INSERT INTO Suppliersphone (Sid, phoneNumber) VALUES
(4, '555-1001'),
(5, '555-1002'),
(6, '555-1003'),
(7, '555-1004'),
(8, '555-1005'),
(9, '555-1006'),
(10, '555-1007');



-- Insert sample data into Warehouses
INSERT INTO warehouses (Wid, capacity, location, numberOfEmployees) VALUES
(1, 1000, 'New York', 7),
(2, 1500, 'Los Angeles', 6),
(3, 2000, 'Chicago', 5);

set FOREIGN_KEY_CHECKS=0;
  
-- Insert sample data into Department
INSERT INTO department (Did, name, numberOfEmployees,Eid) VALUES
(1, 'Sales', 6,1),
(2, 'HR', 6,2),
(3, 'IT', 6,1);


set FOREIGN_KEY_CHECKS=1;

-- Insert sample data into Employee
INSERT INTO employee (Eid, name, address, salary, jobType, Did, Wid,pass) VALUES
(1, 'Alice', '123 Main St', 60000, 'Manager', 1, 1,"12345"),
(2, 'Bob', '456 Elm St', 50000, 'Developer', 3, 1,"54321"),
(3, 'Charlie', '789 Oak St', 55000, 'Analyst', 2, 2,"10000");

INSERT INTO employee (Eid, name, address, salary, jobType, Did, Wid, pass) VALUES
(4, 'David', '321 Maple St', 55000, 'Manager', 1, 2, UNHEX(SHA2('davidpass', 256))),
(5, 'Eve', '654 Birch St', 47000, 'Analyst', 2, 3, UNHEX(SHA2('evepass', 256))),
(6, 'Frank', '987 Elm St', 42000, 'Engineer', 3, 1, UNHEX(SHA2('frankpass', 256))),
(7, 'Grace', '741 Cedar St', 48000, 'Manager', 1, 3, UNHEX(SHA2('gracepass', 256))),
(8, 'Hannah', '852 Walnut St', 46000, 'Analyst', 2, 1, UNHEX(SHA2('hannahpass', 256))),
(9, 'Ian', '963 Spruce St', 43000, 'Engineer', 3, 2, UNHEX(SHA2('ianpass', 256))),
(10, 'Jack', '174 Oak St', 50000, 'Manager', 1, 1, UNHEX(SHA2('jackpass', 256))),
(11, 'Karen', '285 Pine St', 45000, 'Analyst', 2, 2, UNHEX(SHA2('karenpass', 256))),
(12, 'Leo', '396 Maple St', 42000, 'Engineer', 3, 3, UNHEX(SHA2('leopass', 256))),
(13, 'Mia', '417 Cedar St', 51000, 'Manager', 1, 3, UNHEX(SHA2('miapass', 256))),
(14, 'Nina', '528 Walnut St', 47000, 'Analyst', 2, 1, UNHEX(SHA2('ninapass', 256))),
(15, 'Oscar', '639 Spruce St', 44000, 'Engineer', 3, 2, UNHEX(SHA2('oscarpass', 256))),
(16, 'Pam', '750 Oak St', 52000, 'Manager', 1, 1, UNHEX(SHA2('pampass', 256))),
(17, 'Quincy', '861 Pine St', 46000, 'Analyst', 2, 2, UNHEX(SHA2('quincypass', 256))),
(18, 'Rachel', '972 Maple St', 43000, 'Engineer', 3, 3, UNHEX(SHA2('rachelpass', 256)));


-- Insert sample data into Vehicles
INSERT INTO vehicles (Vid, model, yearOfProduction, capacity,numberOfOrders ,licensePlateNumber, licenseExpiryDate, Eid) VALUES
(1, 'Model X', 2020, 1000,200,'ABC123', '2025-12-31', 1),
(2, 'Model Y', 2021, 1500,300 ,'DEF456', '2026-11-30', 2),
(3, 'Model Z', 2022, 2000,250,'GHI789', '2027-10-29', 3);


-- Insert sample data into Client
INSERT INTO client (Cid,name, address, payment_method) VALUES
(1, 'Client A', '123 Maple St', 'Credit Card'),
(2, 'Client B', '456 Oak St', 'PayPal'),
(3, 'Client C', '789 Pine St', 'Cash');

INSERT INTO client (name, address, payment_method) VALUES
('Alice Johnson', '123 Main St', 'Credit Card'),
('Bob Smith', '456 Elm St', 'Debit Card'),
('Carol White', '789 Oak St', 'Cash'),
('David Brown', '101 Maple St', 'Online Payment'),
('Eve Davis', '202 Pine St', 'Credit Card'),
('Frank Moore', '303 Cedar St', 'Debit Card'),
('Grace Wilson', '404 Birch St', 'Cash'),
('Hank Miller', '505 Walnut St', 'Online Payment'),
('Ivy Taylor', '606 Spruce St', 'Credit Card'),
('Jack Anderson', '707 Redwood St', 'Debit Card');

-- Insert sample data into SalesOrder
INSERT INTO salesOrder (SOid, date, discount, totalPrice, Cid, Paytype, paidamount, remaining) VALUES
(1, '2024-06-9', 5.00, 95.00, 1, 'cash', 95.00, 0.00),
(2, '2024-02-20', 7.50, 142.50, 2, 'cheques', 100.00, 42.00),
(3, '2024-03-25', 10.00, 180.00, 3, 'cash', 5.00, 175.00),
(4, '2024-04-15', 12.00, 108.00, 4, 'cash', 50.00, 58.00),
(5, '2024-05-20', 8.00, 92.00, 5, 'credit card', 92.00, 0.00),
(6, '2024-06-01', 15.00, 85.00, 6, 'cheques', 45.00, 40.00),
(7, '2024-07-10', 5.00, 95.00, 7, 'cash', 30.00, 65.00),
(8, '2024-08-15', 10.00, 90.00, 8, 'credit card', 90.00, 0.00),
(9, '2024-09-05', 20.00, 80.00, 9, 'cheques', 40.00, 40.00),
(10, '2024-10-22', 18.00, 82.00, 10, 'cash', 82.00, 0.00),
(11, '2024-11-11', 25.00, 75.00, 8, 'credit card', 75.00, 0.00),
(12, '2024-12-30', 7.00, 93.00, 7, 'cash', 20.00, 73.00),
(13, '2024-01-12', 6.00, 94.00, 2, 'cheques', 50.00, 44.00),
(14, '2024-02-25', 9.00, 91.00, 7, 'cash', 60.00, 31.00),
(15, '2024-03-14', 11.00, 89.00, 1, 'credit card', 89.00, 0.00);




-- Insert sample data into OrderLines
INSERT INTO orderLines (OLid, price, quantity, discount, Pid, SoId) VALUES
(1, 10, 10, 0.1, 1, 1),
(2, 15, 15, 0.05, 2, 2),
(3, 20, 20, 0.2, 3, 3),
(4, 10, 12, 0.1, 1, 4),
(5, 15, 18, 0.05, 2, 5),
(6, 20, 22, 0.2, 3, 6),
(7, 10, 11, 0.15, 1, 7),
(8, 15, 17, 0.1, 2, 8),
(9, 20, 25, 0.25, 3, 9),
(10, 10, 13, 0.05, 1, 10),
(11, 15, 19, 0.2, 2, 11),
(12, 20, 21, 0.1, 3, 12),
(13, 10, 14, 0.15, 1, 13),
(14, 15, 16, 0.05, 2, 14),
(15, 20, 16, 0.05, 3, 14);









-- Insert sample data into PurchaseOrders
INSERT INTO purchaseOrder (POid, date, totalPrice, discount, Sid) VALUES
(1, '2024-04-20', 150.00, 5.00, 1),
(2, '2024-04-30', 300.00, 10.00, 2),
(3, '2024-05-10', 200.00, 7.50, 3);




-- Insert sample data into Employeephone
INSERT INTO Employeephone (Eid, phoneNumber) VALUES
(1, '555-1234'),
(2, '555-5678'),
(3, '555-9012');





-- Insert sample data into Clientphone
INSERT INTO Clientphone (cid, phoneNumber) VALUES
(1, '555-1111'),
(2, '555-2222'),
(3, '555-3333'),
(4, '555-4444'),
(4, '555-4445'),
(5, '555-5555'),
(5, '555-5556'),
(6, '555-6666'),
(6, '555-6667'),
(7, '555-7777'),
(7, '555-7778'),
(8, '555-8888'),
(8, '555-8889'),
(9, '555-9999'),
(9, '555-9990'),
(10, '555-0000'),
(10, '555-0001'),
(11, '555-1111'),
(11, '555-1112'),
(12, '555-2222'),
(12, '555-2223'),
(13, '555-3333'),
(13, '555-3334');



-- Insert sample data into Suppliersphone
INSERT INTO Suppliersphone (Sid, phoneNumber) VALUES
(1, '555-1111'),
(2, '555-2222'),
(3, '555-3333');

INSERT INTO deliveryOrder (Orderid, Driverid, Carid, Orderstatus, OrderDistenation)
VALUES
(1, 1, 1, 'In-delivery', 'Gaza City'),
(2, 2, 2, 'In-delivery', 'Hebron'),
(3, 3, 3, 'In-delivery', 'Jenin');

Insert into inplaceorder (Orderid, Empid) values(1,2);


