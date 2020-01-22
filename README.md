# Spring_Boot_API
3 Spring Boot APIs connected with MySQL database

# # # # # Instruction how to upload and run containers # # # # # <br><br>


# Uploading images:<br>

docker pull docker.pkg.github.com/pszyman/springbootapi/credit.jar:latest<br>

docker pull docker.pkg.github.com/pszyman/springbootapi/customer.jar:latest<br>

docker pull docker.pkg.github.com/pszyman/springbootapi/product.jar:latest<br>

docker pull docker.pkg.github.com/pszyman/springbootapi/mysql:latest<br>


# Starting containers. <br>
Order is important. After starting mysql container wait till it will run properly. Around 2 minutes.<br><br>

docker run --name localhost -p 3306 -e MYSQL_ROOT_PASSWORD=ApriliaRS250! -e MYSQL_DATABASE=database -d docker.pkg.github.com/pszyman/springbootapi/mysql:latest<br>

docker run --detach -p 8082:8082 --name customer --link localhost:mysql docker.pkg.github.com/pszyman/springbootapi/customer.jar<br>

docker run --detach -p 8083:8083 --name product --link localhost:mysql docker.pkg.github.com/pszyman/springbootapi/product.jar<br>

docker run --detach -p 8081:8081 --name credit --link localhost:mysql --link customer --link product docker.pkg.github.com/pszyman/springbootapi/credit.jar<br>


# Application usage:<br>
Application accept following REST commands:<br><br>

1. GET: /Hello "http://localhost:8081/Hello"<br>
  - this command is retunr String Hello<br><br>
  
2 GET: /GetCredits "http://localhost:8081/GetCredits"<br>
 - this command returns in JASON all credits in database. If MySQL database is empty then duirng starting application schema "database" and  tables are created "credit", "customer" and "product".<br>
  - if there is no existing credit with id "1" then application automaticly creat first test record.<br>
  - rexample result of using command:<br><br>
  
   {<br>
        "pesel": "00010100001",<br>
        "name": "testname",<br>
        "surname": "testname",<br>
        "productname": "testname",<br>
        "productvalue": 0,<br>
        "creditId": 1,<br>
        "creditname": "testname"<br>
    }<br><br>
    
3 POST: CreateCredit "http://localhost:8081/CreateCredit"<br>
 - thist command will post datato credit and product database. If customerdon't exist then also custome will be post to table customer.<br>
 - post object in JASON format below:<br><br>
 
 {<br>
        "pesel": "90052300920",<br>
        "name": "Michalina",<br>
        "surname": "Barakadarabada",<br>
        "productname": "kredyt jakis",<br>
        "productvalue": 900,<br>
        "creditname": "mala kasa"<br>
    }<br><br>
 

# Application descritption:<br>

Apprilcation is build from 4 components:<br>
1. Credit spring boot API <br>
2. Customer spring boot API <br>
3. Product spring boot API<br>
4. MySQL database called "database" composewith below tables"<br><br>
    a. credit:<br>
        -int creditid <br>
        -String creditname<br>
        -String pesel<br>
    b. customer:<br>
        -String pesel (one to many relation with join column with credit)<br>
        -String firstname<br>
        -String surname<br>
    c. product:<br>
        -int creditid<br>
        -String productname<br>
        -int value<br>

# GetCredits:

Get REST "GetCredits" request is workingas follow:<br>
 - request is utilizing by credit API<br>
 - credit API is going throug all record in database credit. For each record: 
  - credit API is sending GET request to:<br>
      - customer API to search customer by creditid in  customer database. Customer API is returning object which is data   from table customer<br>
      - product API to search product by creditid in  product database. Product API is returning object which is data from  table product<br>
 -credit API is collecting all data and returnig object with all required information.<br><br>
 
 example ofrequrend object:<br>
 {<br>
        "pesel": "90052300920",<br>
        "name": "Michalina",<br>
        "surname": "Barakadarabada",<br>
        "productname": "kredyt jakis",<br>
        "productvalue": 900,<br>
        "creditId": 2,<br>
        "creditname": "mala kasa"<br>
    }<br><br>
 
 fallback:<br>
 - if one of API(customer or product) is down then fallback method is started. It is prociding to credit api fallback data.<br>
 - example if both services will be down:<br>
 {<br>
        "pesel": "90052300920",<br>
        "name": "first name error",<br>
        "surname": "surname error",<br>
        "productname": "error name",<br>
        "productvalue": 0,<br>
        "creditId": 2,<br>
        "creditname": "mala kasa"<br>
    }<br>
 
 



