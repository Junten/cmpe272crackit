### CMPE 272 Project

Group Member:
Yunting Jiang,
Nathan Song, 
Junteng Tan


* In this project, the following requirements were given to be implemented:
User shall be able to log in with Single Sign On (SSO).
User shall be able to log in with role based, Administrator and General Users.
User shall be able to view, browse, and search the employee information in the web application.
The application shall be hosted on a web server.


* The following features are implemented on this project:
Single Sign On (SSO) by using Okta
Web Application with Java Spring Boot for viewing, browsing, and searching for the enterprise employee information.
Application Deployment on a web server, DigitalOcean
Role Based User Login (Admin, User)

* This is 3-tier web applications, which is organized into three major parts - GUI, business logic and database abstraction. As the Class Diagram showing, we have User Java Class, Employee Java Class, title Java Class, etc. These are the entity of our database tables and belongs to database abstraction. Controllers Java Package, Repository Java Package and Services Java Package handle the business logic. Also, we using JSP for our web page template, which is belongs to GUI. 
