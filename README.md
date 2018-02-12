# food_panda
A RESTful web service for restaurant search and discovery service.<br>

Installation required:<br>
Java 8<br>
mysql<br>
redis<br>
maven<br>
git<br>

How to setup:<br>
Step 1:<br>
Edit database config and Run: FoodPanda/FoodPandaService/src/main/java/fp/db/Setup.java<br>
This file will setup database by installing few tables and create entries in these tables.<br>

Step 2:<br>
Run tomcat using maven plugin.<br>

Thats it.<br>

How to use:<br>
App is in progress. I will add on APIs.<br>
working:<br>
http://localhost:8080/foodpanda/fp_api <br>

Pending:<br>
GET:<br>
http://localhost:8080/foodpanda/restaurant <br>
http://localhost:8080/foodpanda/menu/<restaurant_id> <br>
http://localhost:8080/foodpanda/items/<menu_id> <br>
