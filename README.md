

![](../../clm.png)
App structure:
When client send request to api , data is sent to kafka by clients-ms,
if data send successfully to kafka,  clients-register-ms consume data and save it to own database.
or
if data couldn't send kafka, I save this data to seperated failed-clients database with active status in clients-ms app.
I also added job to clients-register-ms. it works in every 20 seconds and takes failed datas' with active true statuses from failed-clients database and store them in clients database.
after saving data's, job change failed-clients status to false.


You can run app. as below : 

1. docker-compose up

2. call API -  http://localhost:8081/clients - POST

Request body:
{
"name": "gunel",
"surname": "sultanova",
"wage": 1000
}
or 

use 
swagger url : http://localhost:8081/swagger-ui/index.html

--------------------


Improvement:
![](../../Screen Shot 2022-10-09 at 00.29.19.png)


I've added gateway to the system and created multiple instances of client-ms application (geographically etc) to reduce loading in the application.
I would add another module to the app because of kafka-connect configurations instead of using job. when it failed kafka-connect would send data to kafka.
after sending data to kafka. clients-registration application consumes data and stores its own database.