# 🐳 Running the application with Docker (Guide)

### Setting things first
Before proceeding, you will need the following tools properly installed:  
- [Java Development Kit (JDK 17 or later)](https://www.oracle.com/java/technologies/javase/jdk17-0-13-later-archive-downloads.html)  
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)  
- [Insomnia](https://insomnia.rest/download)  
- [Postman](https://www.postman.com/downloads/)  

---
## The use of "docker-compose.yml"
The project features a **docker-compose.yml** file, responsible for starting both the RabbitMQ and Application containers locally.  
To get it running, please follow the next steps:  

### 1. **Clone the repository**  
   ```bash
   git clone https://github.com/KalRSilva/rabbitmq-application.git
   cd rabbitmq-application
   ```
---

### 2. **Start the containers**  
   Use Docker Compose to start both the **Application** and the **RabbitMQ** containers:

   ```bash
   docker-compose up --build
   ```
---

### 3. **Available ports and RabbitMQ console**  
   After successfully starting containers, the following ports are now available:

   ```bash
   Port 8080 -> Runs the application itself
   Port 5672 -> Runs RabbitMQ
   Port 15672 -> Runs the RabbitMQ console
   ```
---

### 4. **Accessing the endpoints**  
   We are going to access **only two** of these endpoints locally.
   
   #### 4.1. Accessing localhost:8080/api/messages
   You can send a message directly by this endpoint, by providing a **JSON** on the following pattern:  
   ```env
   {
     "text" : "Hello, World!",
     "author" : "Kal"  
   }
   ```
   The message will then be returned, ensuring RabbitMQ's **"produce"** and **"receive"** methods are properly working.  

---
   ### Practical example - Insomnia  
   Here's an example of this functionality, by using **Insomnia API client**:  

   <img src="https://i.imgur.com/0OUuhlQ.png" width="1100">

---
   #### 4.2. Accessing localhost:15672
   We are now going to access the **RabbitMQ Console.**  
   You will initially face the following **login** window:

   <img src="https://i.imgur.com/0jWzUIE.png">  

   You can login by using the default **credentials**:  
   - Username: **guest** 
   - Password: **guest**
---

   Once you logged in, you have complete access to your **RabbitMQ Console**:  
   <img src="https://i.imgur.com/tCwwMeo.png" width="1100">

   You can also send messages directly from the **Console**, by following the next steps:
   ```bash
   Queues and Streams -> rabbitmq_queue -> Publish Message -> Payload 
   ```
   After providing a **JSON** on the same format as mentioned before, click **"Publish message"**.

---
   ### Practical example - RabbitMQ Console  
   Following this path, should get you to the following screen:
   <img src="https://i.imgur.com/aTBE9EV.png" width="1100">

---

#### Now that you’ve finished this guide, you can return to the main documentation:  
- [🔙📖 Go back to README](./README.md)
