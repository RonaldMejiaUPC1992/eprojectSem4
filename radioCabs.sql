create database radiocabs
go
use radiocabs
go

create table paymentType(
	paymentTypeID int primary key,
	paymentTypeName varchar(100)
)
go
insert into paymentType values (1, 'Monthly'), (2, 'Quartly')
go

create table registeredType(
	registeredTypeID int primary key,
	registeredTypeName varchar(200) not null
)
go
insert into registeredType values (1, 'Company'), (2, 'Driver'), (3, 'Advertise')
go
create table registeredUnit(
	registrationID varchar(10) primary key,
	name varchar(200) not null,	
	password varchar(50),
	contactPerson varchar(200),
	designation varchar(100),
	faxNumber varchar(20),
	membershipType int,		
	city varchar(100),
	experience int,
	description varchar(200),		
	address varchar(200),
	mobile varchar(20),
	telephone varchar(20),
	email varchar(100),
	registeredTypeID int references registeredType(registeredTypeID),
	photo varchar(200)
)
go
create table billing(
	billingID int identity primary key,
	registrationID varchar(10) references registeredUnit(registrationID) not null,
	paidTypeID int references paymentType(paymentTypeID) not null,
	money float not null,
	purchaseDate date default CURRENT_TIMESTAMP,
	expriateDate date
)
go

create table feedbackType(
	feedbackTypeID int primary key,
	feedbackTypeName varchar(100) not null
)
go
insert into feedbackType values(1, 'Complaint'), (2, 'Suggestion'), (3, 'Compliment')
go
create table feedback(
	feedbackID int identity primary key,
	feedbackTypeID int references feedbackType(feedbackTypeID) not null,
	name varchar(200) not null,
	moblie varchar(20),
	email varchar(100),
	city varchar(100),
	description varchar(200)
)
go

create table administrator(
	adminID int identity primary key,
	email varchar(100) unique not null,
	password varchar(50) not null,
	role int not null
)
go

insert into administrator values('admin@admin.com', '1234', 1)
go

