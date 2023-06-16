create database student_mgnt_jpa;

use student_mgnt_jpa;

create table `students` (
	`student_id` int not null auto_increment,
    `name` nvarchar(500) not null,
	`specialization` nvarchar(500) not null,
    primary key (`student_id`)
);

create table `classes` (
	`class_id` int not null auto_increment,
    `subject` nvarchar(500) not null,
    `duration` int not null,
    primary key (`class_id`)
);

create table `class_enrolment` (
	`student_id` int not null,
    `class_id` int not null,
    `admission_staff_name` nvarchar(500),
    constraint fk_student_id foreign key (`student_id`) references `students`(`student_id`),
    constraint fk_class_id foreign key (`class_id`) references `classes` (`class_id`)
);