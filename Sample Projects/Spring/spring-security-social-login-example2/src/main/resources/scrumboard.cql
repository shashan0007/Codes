1. ***************Create keyspace*********************
CREATE KEYSPACE scrumboard
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

2.use scrumboard ;  (write this keyspace name in casandra.properties)

3.******************creating table sprintteam***************

CREATE TABLE sprintteam(
   SprintTeamId int PRIMARY KEY,
   sprintTeamName text
   );

Insert into sprintteam(
   SprintTeamId,sprintTeamName
   )values(101,’Folks on fire’);


4.**********************Creating table UserStory ********************
CREATE TABLE userstory(
   UserStoryID int,
   UserStoryName text,
   SprintTeamId int PRIMARY KEY,
   Status text
   );
   
Insert into userstory(
   UserStoryID,UserStoryName,SprintTeamID
   )values(1001,’learning casandra’,101);

5.*********************Crating table Task ********************
CREATE TABLE Task(
   TaskID int PRIMARY KEY,
   TaskName text,
   UserName text,
   Status text
   );
   
insert into Task (TaskID,TaskName,UserName,Status) values (1001,'learning casandra','Binit','Process');