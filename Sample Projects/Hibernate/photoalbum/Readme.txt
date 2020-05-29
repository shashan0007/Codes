/*
 * @author Ashish 
 * Created on Jan, 2020 
 */

photoalbum System :
------------------

Purpose :
---------
To demo simplicity of using spring mvc and spring persistence using hibernate integration

Requirement tools :
-------------------
To run photoalbum system, you will need these latest tools :
1. Maven  (http://maven.apache.org/)
2. MySQL  (http://www.mysql.com/)
3. Tomcat (http://tomcat.apache.org/)

Steps :
-------
Steps to run photoalbum system :
1. Downloading Maven at http://maven.apache.org/download.html
2. Install Maven, then set Maven bin directory into your PATH environment variable
2. Extract photoalbum archive into a folder on your hard drive
	- Open up persistenceContext.xml file (photoalbum\src\main\resources\) and change dataSource bean into your MySQL configuration
3. Open a Windows command prompt and navigate to photoalbum folder
   	- Compile "photoalbum" source using "mvn compile" command. This will take a little while, since Maven will download all libraries and keeps them into            your local repository that you need to run this system
   	- Create Web application WAR file using "mvn package" command. This will create deployable WAR file "photoalbum-0.0.1.war"
4. Copy this file into the webapps directory of your Tomcat server directory
5. Open new Windows command prompt, then start the Tomcat server by changing the directory to the bin directory using "startup" command
6. Once the Tomcat server starts up, you have the photoalbum system up and running. Navigate your web browser to                       http://localhost:8080/photoalbum-0.0.1/albums.htm
