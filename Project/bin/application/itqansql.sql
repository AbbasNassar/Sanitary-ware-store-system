drop database alItqan;
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

alter table department add foreign key (Eid) references employee (Eid);



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
 foreign key (cid) references client(cid) on delete cascade
);

-- Create Products table
CREATE TABLE products (
    Pid INT PRIMARY KEY,
    Pname VARCHAR(32),
    price REAL,
    countryOfOrigin VARCHAR(32)
);

-- Create Sales Order table
CREATE TABLE salesOrder (
    SOid INT PRIMARY KEY auto_increment,
    date DATE,
    discount real,
    totalPrice real,
    Cid INT,
    Vid INT,
    FOREIGN KEY (Cid) REFERENCES client(cid) on update cascade on delete cascade,
    FOREIGN KEY (Vid) REFERENCES vehicles(Vid) on delete cascade on update cascade
   -- FOREIGN KEY (OLid) REFERENCES orderLines(OLid) on update cascade on delete cascade

);

-- Create Suppliers table
CREATE TABLE suppliers (
    Sid INT PRIMARY KEY,
    name VARCHAR(32),
    address VARCHAR(32),
    phone_number VARCHAR(32)
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
    FOREIGN KEY (Pid) REFERENCES products(Pid), -- on update cascade on delete cascade,
    FOREIGN KEY (POId) REFERENCES purchaseorder(POid) -- ON UPDATE CASCADE ON DELETE CASCADE
);


-- Create Order Lines table
CREATE TABLE orderLines (
    OLid INT,
    price INT,
    quantity INT,
    discount REAL,
    Pid INT,
    Sales_Order_Id int,
    primary key (OLid, Sales_Order_Id),
    FOREIGN KEY (Pid) REFERENCES products(Pid),
	FOREIGN KEY (Sales_Order_Id) REFERENCES salesorder(SOid) -- on update cascade on delete cascade
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
INSERT INTO products (Pid, Pname, price, countryOfOrigin) VALUES
(1, 'Product A', 10.00, 'USA'),
(2, 'Product B', 15.00, 'China'),
(3, 'Product C', 20.00, 'Germany');

-- Insert sample data into Suppliers
INSERT INTO suppliers (Sid, name, address, phone_number) VALUES
(1, 'Supplier A', '123 Maple St', '555-1234'),
(2, 'Supplier B', '456 Oak St', '555-5678'),
(3, 'Supplier C', '789 Pine St', '555-9012');


-- Insert sample data into Warehouses
INSERT INTO warehouses (Wid, capacity, location, numberOfEmployees) VALUES
(1, 1000, 'New York', 20),
(2, 1500, 'Los Angeles', 25),
(3, 2000, 'Chicago', 30);


set FOREIGN_KEY_CHECKS=0;
  
-- Insert sample data into Department
INSERT INTO department (Did, name, numberOfEmployees,Eid) VALUES
(1, 'Sales', 10,1),
(2, 'HR', 5,2),
(3, 'IT', 15,1);

set FOREIGN_KEY_CHECKS=1;

-- Insert sample data into Employee
INSERT INTO employee (Eid, name, address, salary, jobType, Did, Wid) VALUES
(1, 'Alice', '123 Main St', 60000, 'Manager', 1, 1),
(2, 'Bob', '456 Elm St', 50000, 'Developer', 3, NULL),
(3, 'Charlie', '789 Oak St', 55000, 'Analyst', 2, 2);

-- Insert sample data into Vehicles
INSERT INTO vehicles (Vid, model, yearOfProduction, capacity, licensePlateNumber, licenseExpiryDate, Eid) VALUES
(1, 'Model X', 2020, 1000, 'ABC123', '2025-12-31', 1),
(2, 'Model Y', 2021, 1500, 'DEF456', '2026-11-30', 2),
(3, 'Model Z', 2022, 2000, 'GHI789', '2027-10-29', 3);


-- Insert sample data into Client
INSERT INTO client (Cid,name, address, payment_method) VALUES
(1, 'Client A', '123 Maple St', 'Credit Card'),
(2, 'Client B', '456 Oak St', 'PayPal'),
(3, 'Client C', '789 Pine St', 'Cash');


-- Insert sample data into SalesOrder
INSERT INTO salesOrder (SOid, date, discount, totalPrice, Cid, Vid) VALUES
(1, '2024-01-15', 5.00, 95.00, 1, 1),
(2, '2024-02-20', 7.50, 142.50, 2, 2),
(3, '2024-03-25', 10.00, 180.00, 3, 3);


-- Insert sample data into OrderLines
INSERT INTO orderLines (OLid, price, quantity, discount, Pid, Sales_Order_Id) VALUES
(1, 100, 10, 0.1, 1, 1),
(2, 150, 15, 0.05, 2, 2),
(3, 200, 20, 0.2, 3, 3);



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
(3, '555-3333');



-- Insert sample data into Suppliersphone
INSERT INTO Suppliersphone (Sid, phoneNumber) VALUES
(1, '555-1111'),
(2, '555-2222'),
(3, '555-3333');


-- Select all data from OrderLines
SELECT * FROM orderLines;

-- Select all data from Products
SELECT * FROM products;

-- Select all data from Suppliers
SELECT * FROM suppliers;

-- Select all data from PurchaseOrders
SELECT * FROM purchaseOrder;

select * from vehicles;

select * from client;

select * from clientphone;

select * from department;

select * from salesorder;

-- select * from salesorder So, products P, orderLines Ol
-- where 
   