# Template System Backend
<hr/>

### Setup Docker Mongo Container
1. Pull Mongo latest image. <br/>
```docker pull mongo```
2. Run container locally on PORT 27070. <br/>
```docker run -p 27070:27017 --name mongodb -d mongo```
3. Hit ```docker ps``` and see check the container is up and running.
   Use this command to check Mongo console if you need: ```docker exec -it mongodb bash```. After that hit ```mongo``` and enter the terminal(This is optional).
4. Just run the backend if mongo is running.
5. Please note that ```TemplateRunner``` class will create a set of **dummy templates by** default, whenever backend is started.
6. Please note, when docker mongo instance is restarted, data will be lost - need to fix that.

### API Documentation
1. This will give you all the APIs and POJOs exposed in the backend.
<br/>
Link: http://localhost:8000/swagger-ui/index.html?configUrl=/workflow-db
2. If you want, you can use this as the API play ground also, for this backend.

### Actuator Endpoints
Links: http://localhost:8000/admin
* This API is used to show the status of backend: ```http://localhost:8000/admin/health```
* You can see a blinking indicator on UI Navbar. It's changing the color based on this API.