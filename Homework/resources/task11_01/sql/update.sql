INSERT INTO employees.DEPARTMENT
	(ID, NAME, PHONE)
VALUES
	(1,'Sales','2439130'),
  (2,'IT','5549915'),
  (3,'Management','2749209');

INSERT INTO employees.EMPLOYEE
  (ID,SURNAME,NAME,POSITION,DEPARTMENT_ID)
VALUES
  (1,'Avram','Rush','salesman',1),
  (2,'Dennis','Duran','salesman',1),
  (3,'Clark','Pacheco','developer',2),
  (4,'Cullen','Romero','developer',2),
  (5,'Leo','Buchanan','developer',2),
  (6,'Camden','Silva','salesman',1),
  (7,'Brody','Patrick','developer',2),
  (8,'Stuart','Navarro','developer',2),
  (9,'Raja','Marks','salesman',1),
  (10,'Alexander','Huber','developer',2),
  (11,'Benjamin','Holmes','manager',3),
  (12,'Quamar','Kennedy','developer',2),
  (13,'Alfonso','Delgado','developer',2),
  (14,'Graiden','Cole','developer',2),
  (15,'Phillip','Merrill','salesman',1),
  (16,'Kibo','Howe','salesman',1),
  (17,'Alfonso','Walter','developer',2),
  (18,'Odysseus','Burns','developer',2),
  (19,'Demetrius','Leach','salesman',1),
  (20,'Tiger','Durham','manager',3);


INSERT INTO employees.TASK
  (ID,DESCRIPTION,EMPLOYEE_ID)
VALUES
  (1,'Task 1',1),
  (2,'Task 2',3),
  (3,'Task 3',5),
  (4,'Task 4',7),
  (5,'Task 5',9),
  (6,'Task 6',11),
  (7,'Task 7',13),
  (8,'Task 8',15),
  (9,'Task 9',17),
  (10,'Task 10',18);

