create database radiocabs
go
use radiocabs
go

create table paymentType(
	paymentTypeID int primary key,
	paymentTypeName nvarchar(100)
)
go
insert into paymentType values (1, 'Monthly'), (2, 'Quartly')
go

create table registeredType(
	registeredTypeID int primary key,
	registeredTypeName nvarchar(200) not null
)
go
insert into registeredType values (1, 'Company'), (2, 'Driver'), (3, 'Advertise')
go
create table registeredUnit(
	registrationID varchar(10) primary key,
	name nvarchar(200) not null,	
	password varchar(50) not null,
	contactPerson nvarchar(200),
	designation nvarchar(100),
	faxNumber varchar(20),
	membershipType int,		
	city nvarchar(100),
	experience int,
	description nvarchar(200),		
	address nvarchar(200),
	mobile varchar(20),
	telephone varchar(20),
	email varchar(100),
	registeredTypeID int references registeredType(registeredTypeID),	
	status bit	
)
go
create table payment(
	paymentID int identity primary key,
	registrationID varchar(10) references registeredUnit(registrationID) not null,
	paidTypeID int references paymentType(paymentTypeID) not null,
	money float not null,
	purchaseDate date default CURRENT_TIMESTAMP,
	expriateDate date
)
go

create table feedbackType(
	feedbackTypeID int primary key,
	feedbackTypeName nvarchar(100) not null
)
go
insert into feedbackType values(1, 'Complaint'), (2, 'Suggestion'), (3, 'Compliment')
go
create table feedback(
	feedbackID int identity primary key,
	feedbackTypeID int references feedbackType(feedbackTypeID) not null,
	name nvarchar(200) not null,
	moblie varchar(20),
	email varchar(100),
	ciry nvarchar(100),
	description nvarchar(200)
)
go

create table administrator(
	adminID int identity primary key,
	email varchar(100) unique not null,
	password varchar(50) not null,
	role int not null
)
go

