create table `company`(
`id` int primary key auto_increment,
`name` varchar (50),
`email` varchar (50),
`password` varchar (50)
);

create table `customer` (
`id` int primary key auto_increment,
`first_name` varchar (50),
`last_name` varchar (50),
`email` varchar (50),
`password` varchar (50)
);

create table `coupon` (
`id` int primary key auto_increment,
`company_id` int,
`category` varchar (50),
`title` varchar (50),
`description` varchar (100),
`start_date` date,
`end_date` date,
`amount` int,
`price` double,
`image` varchar(225),
foreign key (`company_id`) references `company`(`id`)
);

create table `customer_coupon` (
`customer_id` int ,
`coupon_id` int ,
primary key(`customer_id`, `coupon_id`),
foreign key (`customer_id`) references `customer`(`id`),
foreign key (`coupon_id`) references `coupon`(`id`)
);
