# food_panda
A RESTful web service for restaurant search and discovery service.

Installation required:
Java 8
mysql
redis
maven
git

How to setup:
Step 1:
Edit database config and Run: FoodPanda/FoodPandaService/src/main/java/fp/db/Setup.java
This file will setup database by installing few tables and create entries in these tables.

Step 2:
Run tomcat using maven plugin.

Thats it.

How to use:
App is in progress. I will add on APIs.
working:
http://localhost:8080/foodpanda/fp_api 

Pending:
GET:
http://localhost:8080/foodpanda/restaurant
http://localhost:8080/foodpanda/menu/<restaurant_id>
http://localhost:8080/foodpanda/items/<menu_id>
