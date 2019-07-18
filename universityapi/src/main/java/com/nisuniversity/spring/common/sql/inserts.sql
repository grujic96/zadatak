create database nisuniversity;
use nisuniversity;


/*after hibernate create tables execute inserts for demo data */

insert into studententity(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Aleksandar', 'Grujic','3454345434','1996-03-18 00:00:00', 'Gligorija Diklica 31','aleksandar.grujicc@gmail.com','0629782743');
insert into studententity(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Aleksandar', 'Nikolic','543543534','1993-04-15 00:00:00', 'Bulevar Nemanjica 31','aleksandar.nikolic@gmail.com','0643243443');
insert into studententity(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Mihajlo', 'Micic','123123123','1995-05-12 00:00:00', 'Proleterska 109','mihajlomicic@gmail.com','0662932343');
insert into studententity(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Milan', 'Djokic','321321321','1996-02-21 00:00:00', 'Carnojevica 10','milandjokic@gmail.com','0614343443');
insert into studententity(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Nemanja', 'Ilic','654654654','1980-12-22 00:00:00', 'Bore Piksle 10','nemanjailic@gmail.com','060232323');

insert into collegeentity(name,address,email,phone_number) values ('Elektronski Fakultet', 'sdad','elfak@elfak.rs','432423');
insert into collegeentity(name,address,email,phone_number) values ('PMF', 'dsad','pmf@pmf.rs','123123');
insert into collegeentity(name,address,email,phone_number) values ('Medicinski Fakultet', 'fdsf','med@med.rs','65464');
insert into collegeentity(name,address,email,phone_number) values ('Pravni Fakultet', 'erwr','pravninis@gmail.rs','54354');

insert into studententity_collegeentity(students_student_id, colleges_college_id) values(1,1);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(2,1);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(3,2);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(3,3);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(3,1);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(1,2);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(4,1);
insert into studententity_collegeentity(students_student_id, colleges_college_id) values(5,1);



