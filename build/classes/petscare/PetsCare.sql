/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Maryam Tariq
 * Created: May 5, 2022
 */

CREATE TABLE Admins (
    AdminID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    Phone INT NOT NULL,
    Gender varchar (1) NOT NULL,
    Age INT NOT NULL,
    UserName varchar (20) NOT NULL,
    Password varchar (20) NOT NULL,
    FirstName varchar (20) NOT NULL,
    LastName varchar (30) NOT NULL,
    PRIMARY KEY (AdminID)
);

CREATE TABLE Employee (
    EmployeeID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    Phone INT NOT NULL,
    Gender varchar (1) NOT NULL,
    Age INT NOT NULL,
    UserName varchar (20) NOT NULL,
    Password varchar (20) NOT NULL,
    FirstName varchar (20) NOT NULL,
    LastName varchar (30) NOT NULL,
    Salary INT NOT NULL,
    WorkingHours INT NOT NULL,
    AdminID INT NOT NULL,
    PRIMARY KEY (EmployeeID),
    FOREIGN KEY (AdminID) REFERENCES admins(AdminID) 
);

CREATE TABLE Customer (
    CustomerID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    FirstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    Gender VARCHAR(1) NOT NULL,
    UserName VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    Phone INT NOT NULL,
    Email VARCHAR(100) NOT NULL,
    PRIMARY KEY (CustomerID)
);


CREATE TABLE Pet (
    PetID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    Pet_Name varchar (20) NOT NULL,
    Age varchar (45) NOT NULL,
    Species varchar (45) NOT NULL,
    Price double NOT NULL,
    Pet_Type varchar (45) NOT NULL,
    ImagePath varchar(100) NOT NULL,
    AdminID INT NOT NULL,
    PRIMARY KEY (PetID),
    FOREIGN KEY (AdminID) REFERENCES admins(AdminID) 
);


CREATE TABLE Food (
    FoodID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    Food_Name varchar (100) NOT NULL,
    Price double NOT NULL,
    VendorName varchar (45) NOT NULL,
    Food_Type varchar (45) NOT NULL,
    Quantity INT NOT NULL,
    ImagePath varchar(100) NOT NULL,
    AdminID INT NOT NULL,
    PRIMARY KEY (FoodID),
    FOREIGN KEY (AdminID) REFERENCES admins(AdminID) 
);

CREATE TABLE Supplies (
    SuppliesID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    Supplies_Name varchar (45) NOT NULL,
    Price double NOT NULL,
    Quantity INT NOT NULL,
    ImagePath varchar(100) NOT NULL,
    AdminID INT NOT NULL,
    PRIMARY KEY (SuppliesID),
    FOREIGN KEY (AdminID) REFERENCES admins(AdminID) 
);

CREATE TABLE Orders(
    OrderID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    CustomerID INT NOT NULL,
    TotalAmount double NOT NULL,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

INSERT INTO Admins (Phone, Gender, Age, UserName, Password, FirstName, LastName)
VALUES 
    (0545181812,'M', 29, 'Mohammed', 'ihdf2', 'Mohammed', 'smith'), 
    (0545181834,'M', 27, 'Tala331', 'ckas9', 'Talal', 'smith'), 
    (0501937412,'F', 30, 'Nor__4ah', '39djdx', 'Norah', 'garia'), 
    (0545184402,'F', 28, 'Shahad_2', 'cojo01', 'Shahad', 'novak'), 
    (0545131183,'F', 31, 'Maryam55', 'Mar5yam', 'Maryam', 'Tariq'), 
    (0513914849,'M', 29, 'ALi_E', '29ukdh', 'Ali', 'lum'), 
    (0519891092,'M', 28, 'Malik__99', 'akiz2l', 'Malik', 'barr'), 
    (0521568291,'F', 33, 'Fay22', 'kfsfah', 'Fay', 'adelman'), 
    (0547102947,'M', 29, 'Samy600', 'wdOcs', 'Samy', 'forbis'), 
    (0521781004,'F', 26, 'ghadah00', '49skss', 'Ghadah', 'lee');


INSERT INTO Supplies (Supplies_Name, Price, Quantity, ImagePath ,AdminID)
VALUES
    ('Dog Bed',183.9,40,'DogBed.png',1),
    ('Dog Kennel',204.1,28,'DogKennel.png',2),
    ('Cat Bed',144.5,40,'CatBed.png',7),                                                             
    ('Cat Kennel',201,13,'CatKennel.png',4),
    ('Dog Shampoo',29,46,'DogShampoo.png',8),
    ('Cat Shampoo',30,49,'CatShampoo.png',1),
    ('Cat Nail Scissor',20.4,20,'CatNailScissor.png',7),
    ('Dog Nail Scissor',20.4,58,'DogNailScissor.png',8),
    ('Dog Comb',15.9,68,'DogComb.png',9),
    ('Cat Comb',15.9,10,'CatComb.png',10);


INSERT INTO Food (Food_Name, VendorName, Price, Food_Type, Quantity, ImagePath, AdminID)
VALUES
    ('Cat Chicken Dry Food', 'Purina', 22.99, 'Dry', 35, 'CatChickenDryFood.png',2),
    ('Cat Tuna Treat', 'KitCat',18.5,'Dry',25 , 'CatTunaTreat.png',2),
    ('Cat Beef Dry Food', 'Applaws',16.25, 'Dry',25, 'CatBeefDryFood.png',5),
    ('Cat Canned Chicken', 'Purina',17.5,'Wet',20, 'CatCannedChicken.png',10),
    ('Cat Canned Tuna', 'Inaba',62.99,'Wet',30, 'CatCannedTuna.png',4),
    ('Dog Salamon Dry Food','Brits', 70,'Dry',30, 'DogSalamonDryFood.png',4),
    ('Dog Beef Canned','Schesir', 18.63,'Wet',25, 'DogBeefCanned.png',5),
    ('Dog Treat','Chappell',23,'Dry',28, 'DogTreat.png',10),
    ('Dog Chicken Dry Food','Applaws', 55.5, 'Dry',35, 'DogChickenDryFood.png',1),
    ('Dog Canned Chicken','Applaws', 46,'Wet',20, 'DogCannedChicken.png',8);


INSERT INTO Pet (Age, Species, Pet_Name, Price, AdminID, Pet_Type, ImagePath)
VALUES
    ('2 months','American Shorthair','SBSS',3000,1,'Cat', 'SBSS.png'),
    ('4 years','Persian','NONY',1900,2,'Cat', 'NONY.png'),
    ('10 months','British','LOLY',3200.6,10,'Cat', 'LOLY.png'),
    ('3 months','Scottish Fold','OLLIE',1984.2,5,'Cat', 'OLLIE.png'),
    ('1 year','Munchkin','LUNA',2000.9,5,'Cat', 'LUNA.png'),
    ('1 year','Pomeranian','ROCKY',2900,6,'Dog', 'ROCKY.png'),
    ('3 months','Husky','CHARLIE',3810,2,'Dog', 'CHARLIE.png'),
    ('4 months','Toy Dog','FINN',3200,8,'Dog', 'FINN.png'),
    ('8 months','Jack Russell Terrier','LOKI',2593,9,'Dog', 'LOKI.png'),
    ('5 years','Samoyed','JACK',1800,5,'Dog', 'JACK.png');

INSERT INTO Employee (Phone, Gender, Age, UserName, Password, FirstName, LastName, Salary, WorkingHours, AdminID)
VALUES 
    (0563823865, 'M', 22, 'Ah_med9','A12*A12*', 'Ahmed','Naser',4000,7,1),
    (0576568527, 'M', 25, 'Mohammed34', 'mhmd22', 'Mohammed', 'Tariq', 4500, 8, 3),
    (0513476789, 'F', 24, 'Sa_ra55', 'srx34sr', 'Sara', 'Rashid', 4000, 7, 1),
    (0535649642, 'M', 33, 'Sulaiman11', 'Sxio456', 'Sulaiman', 'Khalid', 4000, 7, 7),
    (0535837639, 'F', 27, 'ManalALi', 'Mi77X1', 'Manal', 'Ali', 4500, 8, 7),
    (0525283435, 'F', 25, 'Maryam', 'Maryam', 'Maryam', 'Tariq', 5000, 8, 5),
    (0515487327, 'F', 28, 'Hvdxl', 'hvd55L', 'Hadeel', 'Ali', 3500, 6, 3),
    (0548975492, 'M', 26, 'Faisal44', 'Fxj90pp', 'Faisal', 'Mohammed', 4500, 8, 3),
    (0551457963, 'M', 22, 'Anas66', 'Anxii00', 'Anas', 'Khalil', 4000, 7, 1),
    (0575485471, 'M', 30, 'Om_ar', 'Omvr345', 'Omar', 'Fahad', 3500, 6, 9);

INSERT INTO Customer ( FirstName, LastName, Gender, UserName, Password, Phone, Email)
VALUES 
    ('Ali', 'smith', 'M', 'Ali_3', '39aza8%', 0563823862, 'ali3@gmail.com'),
    ('Mansour', 'Ali', 'M', 'Mansour5', 'dvk@hvdk', 0563389000, 'mansour5@hotmail.com'),
    ('Latifah', 'Soultan', 'F', 'lati_fah', 'feiioo##', 0539288292, 'loloSult@hotmail.com'),
    ('Marya', 'Nasser', 'F', 'maaaary', 'svisjimvo', 0288473889, 'MarNas12@gmail.com'),
    ('Soha', 'Ali', 'F', 'soha__2', 'vcsk*1', 0592947299, 'sosoAli1990@hotmail.com'),
    ('Maryam', 'Tariq', 'F', 'Maryam2001', 'Maryam2001', 0561392088, 'mzts5@hotmail.com'),
    ('Asrar', 'Mohammed', 'F', 'as__rar', 'dchs&hc', 0520484232, 'Asrar55@hotmail.com'),
    ('Nasser', 'Rayan', 'M', 'na1sser', 'vkodoai00', 0592382948, 'Nasser2001@gmail.com'),
    ('Yousef', 'Saad', 'M', 'yous4ef', 'cjdooo*8', 0593884891, 'YousefSaad4@hotmail.com'),
    ('Gamr', 'Saad', 'F', 'gamr0', '&jfkss', 0567590102, 'mzts2001@hotmail.com');


INSERT INTO Orders(CustomerID, TotalAmount)
VALUES 
    (2, 148.5),
    (6, 1200),
    (4, 220.95),
    (4, 52),
    (1, 160),
    (8, 305.3),
    (2, 79.5),
    (3, 32.9),
    (5, 55),
    (7, 400);