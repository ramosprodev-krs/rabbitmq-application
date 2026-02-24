# 📄 Code documentation
This document describes the architectural and design patterns chosen for this project, aiming at the best deliverance of its logical and functional descriptions. For this goal to be achieved, the project was structured by following a Layered/Modular Architecture that utilizes RabbitMQ for asynchronous messaging. Aside the descriptions that follow next, the code also has additional comments inside of the files.

As the project by itself features further patters, we'll be looking at each one of them throughout this file.

### Adressed topics:
- Layered/Modular Architecture (as mentioned before)
- DTO
- Configuration
- Producer  
- Consumer
- Controller  

---

## 1. Layered/Modular Architecture
Each one of the classes has its own directory/file.    
This principle is really effective and useful, as it provides organization, better testability, refactoring and maintainability.

We can find these aspects when analysing the [rabbitmq_application](./src/main/java/krs/rabbitmq_application) directory:  

<img src="https://i.imgur.com/bch4PV1.png">

---

## 2. DTO class
Starting off, I developed the DTO class first.  
The reason is because it is the most simple class of the project, also where we set the attributes for the message we'll manage

The primary role of **MessageDTO** is to act as the standardized payload for all asynchronous messages managed by RabbitMQ.  

### 2.1 Class creation  
To fulfill this demand, the **[MessageDTO](./src/main/java/krs/rabbitmq_application/dto/MessageDTO.java)** class has been created.  

**MessageDTO** Class:  

---

<img src="https://i.imgur.com/Gt8vliD.png">

---

### 2.2 Class attributes 
**text (String)**: Represents the core content or primary instruction of the message.  
**author (String)**: Identifies the originator or source system of the message.


### 2.3 The method
The method **"toString()"** was overrided for a better display of the messages.

---

## 3. Configuration class/directory
The configuration class is responsible for establishing the entire **messaging environment** and defining how messages are **prepared** and **sent**.  
Surely the most complex of all the classes developed.  

This class also has an important role, by managing the **Queue**, **Exchange** and **Routing Key**.

### 3.1 Class creation  
To fulfill this demand, the **[RabbitMQConfiguration](./src/main/java/krs/rabbitmq_application/configuration/RabbitMQConfiguration.java)** class has been created.  

**RabbitMQConfiguration** Class:  

---

<img src="https://i.imgur.com/AQySCHS.png">
<img src="https://i.imgur.com/BgjxO2y.png">  
<img src="https://i.imgur.com/OzxszFA.png">

---

### 3.2 Class attributes 
The class defines three static constants that establish the physical names of the required messaging entities on the RabbitMQ broker:
```bash
EXCHANGE (String): The definitive name of the Exchange. This is where the Producer will send all messages.
QUEUE (String): The definitive name of the Queue. This is where messages are durably stored.
ROUTING_KEY (String): Used to create the link between the Exchange and the Queue.
```

### 3.3 Class Beans
Message path realated Beans:
```bash
queue(): Declares the Queue on the broker. Structures safety across broker restarts.
directExchange(): Sets the type Direct for the Exchange. Messages are routed based on an exact key match.
binding(): Creates the Binding routing rule that links the  Queue to the Exchange.
```

Communication realated Beans:
```bash
messageConverter(): Initializes the Jackson2JsonMessageConverter. This component automatically handling the serialization and deserialization.

rabbitTemplate(): Initializes the core RabbitTemplate. It is configured to use the messageConverter().
```

---

## 4. Producer class/directory
This class is responsible for implementing the RabbitMQTemplate, therefore for handling the physical sending of messages to the RabbitMQ Exchange.

### 4.1 Class creation
To fulfill this demand, the **[MessageProducer](./src/main/java/krs/rabbitmq_application/producer/MessageProducer.java)** class has been created. 

**MessageProducer** Class:   

---

<img src="https://i.imgur.com/25LsN3b.png">

---

### 4.2 Class method
The **"send()"** method utilizes the configured RabbitTemplate to serialize the MessageDTO into JSON and asynchronously publish it to the designated EXCHANGE using the ROUTING_KEY.

---

## 5. Consumer class/directory
The Consumer class serves the purpose of being the destination point for all messages sent through the RabbitMQ topology.

### 5.1 Class Creation
To fulfill this demand, the [MessageConsumer](./src/main/java/krs/rabbitmq_application/consumer/MessageConsumer.java) class has been created.

**MessageConsumer** Class:  

---

<img src="https://i.imgur.com/5efnXem.png">

---

### 5.2 Class method
The **"send()"** method utilizes the configured RabbitTemplate to serialize the MessageDTO into JSON and asynchronously publish it to the designated EXCHANGE using the ROUTING_KEY.

## 6. Controller class
The last class that has been developed, it provides the entry point for external communication (HTTP requests) into the application.

### 6.1 Class creation
To fulfill this demand, the [MessageController](./src/main/java/krs/rabbitmq_application/controller/MessageController.java) class has been created.  

**MessageConsumer** Class:  

---

<img src="https://i.imgur.com/nb244qR.png">

---

### 6.2 Class method
The **"sendMessage()"** method receives the HTTP POST request, deserializes the body into a MessageDTO, and immediately delegates the data to the Producer to launch the asynchronous workflow.

---

  #### Now that you’ve finished reading this file, you can return to the main documentation:  
- [🔙📖 Go back to README](./README.md)
