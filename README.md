# FinanceKing
Demo project for Spring Boot

### Description
FinanceKing is a prototype of Spring Boot REST API backend for a financial service platform, which also has a fully responsive frontend made with React. The API is not fully built yet, but some microservices are already live. This is a personal project I decided to do to put my Java skills to a test while learning Spring Boot. As I always do, I create a personal project after learning a new language or framework.

### Completed
#### Backend
* Creation, Retrieving and Updating of User.
* Creating, Retrieving and Updating an Account (Bank account) of user. (Accounts are linked to Users)
* Creating, Retrieving and Updating a Transaction (Transactions are linked to Accounts)
* Implemented Spring Security to authenticate users using JWT Token
* Generation of JWT Tokens
* Refreshing of JWT Tokens to keep a users session active
#### Frontend
* Registration Page for creating a user
* Sign In Page For Logging in (When login details are correct, a JWT Token is successfully sent by the backend REST API. This can be seen from response tab in Postman or developer tools of your browser)

### Todo
* Navigate user to Homepage when sign in is successful
* Ability to create an account from front end
* Ability to create transactions from the front end (When a user logs in)
* Implement Logout system

### Challenges Faced Doing Project
* The most challenging part of the project was implementing Spring Security. This is because I was implementing it at a time when WebSecurityConfigureAdapter had just been deprecated and all tutorials on the web used WebSecurityConfigureAdapter. Luckily for me, Amigos Code from Youtube released a video which he used Spring Security 6.
* The second challenge is time, because i was doing all this while being a student of University of Ghana. Had to balance time between work, other personal project (UG Partner - which I launched within same period) and this project.
* Learnt a lot while doing this project (Example, Cardinality of database relationships, Spring Security, Spring Boot Application creation processes, Spring Boot Annotations, etc)

### Running of Application
* Create and run database server preferrable using PostgreSQL or database of your choice and make neccessary changes to FinanceKing/src/main/resources/application.properties
* Open project in your IDE (IntelliJ IDEA - preffered or Eclipse) and run project to start backend
* Open your terminal and navigate to FinanceKing/frontend and enter command "npm start" to start frontend
* Follow link in terminal.
