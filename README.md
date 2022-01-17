# ToDoList
    A simple to-do list where you can add, delete, edit or change the status of your task
    The project was built by Java, Spring Framework, using Postgres DB
![Alt text](https://cdn.discordapp.com/attachments/557505548581339148/929360480835895316/unknown.png "test")
# How to Install
**1. Clone the repository** 

`git clone https://github.com/teyago/ToDoList-spring`

**2. Configure PostgreSQL** 

First, create a database named **todolist**

Then, open src/main/resources/database.properties file and change
username and password as per your PostgreSQL installation.

**3. Run the app**
Type the following command from the root directory of 
the project to run it:

`mvn clean package`

`cd target`

`java -jar todolist-0.0.1-SNAPSHOT.jar`

Open browser and go to _http://localhost:8080/notes_
