# Spring_Boot_API
3 Spring Boot APIs connected with MySQL database

# # # # # Instruction how to upload and run containers # # # # # 

# Uploading images:

docker pull docker.pkg.github.com/pszyman/springbootapi/credit.jar:latest

docker pull docker.pkg.github.com/pszyman/springbootapi/customer.jar:latest

docker pull docker.pkg.github.com/pszyman/springbootapi/product.jar:latest

docker pull docker.pkg.github.com/pszyman/springbootapi/mysql:latest

# Starting containers. 
Order is important. After starting mysql container wait till it will run properly. Around 2 minutes.

docker run --name localhost -p 3306 -e MYSQL_ROOT_PASSWORD=ApriliaRS250! -e MYSQL_DATABASE=database -d docker.pkg.github.com/pszyman/springbootapi/mysql:latest


docker run --detach -p 8082:8082 --name customer --link localhost:mysql docker.pkg.github.com/pszyman/springbootapi/customer.jar


docker run --detach -p 8083:8083 --name product --link localhost:mysql docker.pkg.github.com/pszyman/springbootapi/product.jar


docker run --detach -p 8081:8081 --name credit --link localhost:mysql --link customer --link product docker.pkg.github.com/pszyman/springbootapi/credit.jar


# Application usage:

Application accept following REST commands:
1. GET: /Hello "http://localhost:8081/Hello"
  - this command is retunr String Hello
  
2 GET: /GetCredits "http://localhost:8081/GetCredits"
 - this command returns in JASON all credits in database. If MySQL database is empty then duirng starting application schema "database" and  tables are created "credit", "customer" and "product".
  - if there is no existing credit with id "1" then application automaticly creat first test record. 
  - rexample result of using command:
  
   {
        "pesel": "00010100001",
        "name": "testname",
        "surname": "testname",
        "productname": "testname",
        "productvalue": 0,
        "creditId": 1,
        "creditname": "testname"
    }
    
3 POST: CreateCredit "http://localhost:8081/CreateCredit"
 - thist command will post datato credit and product database. If customerdon't exist then also custome will be post to table customer.
 - post object in JASON format below:
 
 {
        "pesel": "90052300920",
        "name": "Michalina",
        "surname": "Barakadarabada",
        "productname": "kredyt jakis",
        "productvalue": 900,
        "creditname": "mala kasa"
    }
 

# Application descritption:

Apprilcation is build from 4 components:
1. Credit spring boot API
2. Customer spring boot API 
3. Product spring boot API
4. MySQL database called "database" composewith below tables"
    a. credit:
        -int creditid
        -String creditname
        -String pesel
    b. customer:
        -String pesel (one to many relation with join column with credit)
        -String firstname
        -String surname
    c. product:
        -int creditid
        -String productname
        -int value

# GetCredits:

Get REST "GetCredits" is sending request to  credit API"
 - creditapi



