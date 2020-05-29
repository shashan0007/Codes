1. ***************Create keyspace*********************
CREATE KEYSPACE scrumboard
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

2.use scrumboard ;  (write this keyspace name in casandra.properties)

3.******************creating table sprintteam***************

Create table scrum(
scrumname text,
scrumid int PRIMARY KEY);
Insert into scrum(scrumname,scrumid) values('Scrum1',1);
Insert into scrum(scrumname,scrumid) values('Scrum2',2);
Insert into scrum(scrumname,scrumid) values('Scrum3',3);


CREATE TABLE sprintteam(
   SprintTeamId int PRIMARY KEY,
   teamname text,
   sprintname text
   );

Insert into sprintteam(
   SprintTeamId,teamname,sprintname
   )values(101,’Folks on fire’,'Sprint 1');
 
 Insert into sprintteam(
   SprintTeamId,teamname,sprintname
   )values(007,’Ashish the Champ’,'Sprint 1');
   
 Insert into sprintteam(
   SprintTeamId,teamname,sprintname
   )values(008,’Ashish the Champ’,'Sprint 2'); 


4.**********************Creating table UserStory ********************
CREATE TABLE userstories(
   UserStoryID int PRIMARY KEY,
   UserStoryName text,
   scrumid int,
   Status text,
   owner text,
   date Date
   );
   
Insert into userstory(
   UserStoryID,UserStoryName,SprintTeamID
   )values(1001,’learning casandra’,101);
   
   Insert into userstory(
   UserStoryID,UserStoryName,SprintTeamID
   )values(1002,’learning casandra’,101);

5.*********************Crating table Task ********************
CREATE TABLE Task(
   TaskID int PRIMARY KEY,
   UserStoryID int,
   TaskName text,
   UserName text,
   Status text
   );
   
insert into Tasks (TaskID,UserStoryID,TaskName,UserName,Status,Date) values (201,1001,'learning casandra','Binit','Process','2013-10-11');


CREATE TABLE Tasks(
   TaskID int PRIMARY KEY,
   UserStoryID int,
   TaskName text,
   UserName text,
   Status text,
   Date date
   );

CREATE TABLE User(
   email text PRIMARY KEY,
   password text,
   firstname text,
   lastname text,
   phone text,
   );
   
   insert into User (email,firstname,lastname,password,phone) values ('ash@gmail.com','Ashish','kumar singh','abc123','8899644156');