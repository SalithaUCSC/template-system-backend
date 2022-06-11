# Template System Backend
<hr/>

### Setup Docker Mongo Container
1. Pull Mongo latest image. <br/>
```docker pull mongo```
2. Run container locally on PORT 27070. <br/>
```docker run -p 27070:27017 --name mongodb -d mongo```
3. Hit ```docker ps``` and see check the container is up and running.
   Use this command to check Mongo console if you need: ```docker exec -it docker-mongo bash```. After that hit ```mongo``` and enter the terminal(This is optional).
4. Just run the backend if mongo is running.

### Swagger UI
This will give you all the APIs exposed in the backend.
<br/>
Link: http://localhost:8000/swagger-ui/index.html?configUrl=/workflow-db


### Actuator Endpoints
Link: http://localhost:8000/admin