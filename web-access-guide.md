# 🌐 Accessing the Web hosted application (Guide)
For the application to be successfully deployed on WEB, I have **separately** hosted the services:  
- The main application is hosted on Render  
- RabbitMQ is hosted on CloudAMQP

 Before testing, make sure you have any  **API Client** installed.  
 In the following section, we'll be using **[Insomnia API Client](https://insomnia.rest/download)**.

---

## 1. Tests using API Clients
This is **URL** where the endpoint dedicated for sending messages is hosted, you can copy and paste it into your **API Client**.
```env
https://rabbitmq-application-docker-v1.onrender.com/messages
```

Once you have pasted the URL, to send a message simply apply a POST method with the following JSON body:  
```env
{  
 "text" : "I am using a WEB Application.",
 "author" : "Kal"  
}
```
---
### 1.1 Practical example - Insomnia
<img src="https://i.imgur.com/kUcPxd2.png" width="1100">

---

### 1.2 Logs  
After sending our request, we can check the outcome on **Render**:  

<img src="https://i.imgur.com/hfhzylV.png" width="1100"> 

---

## 2. Tests using RabbitMQ Console (Supervised access only)
To verify messages directly through the RabbitMQ Management Console, you can access the instance hosted on **CloudAMQP**.

> ⚠️ Access to the console is **supervised** and requires authorization, as it exposes credentials and sensitive queue data.

If access was confirmed, you may replace the "<domain>" with the correct one.   
Following, copy and paste the **URL** into your browser:  
```env
<domain>.rmq.cloudamqp.com
```

---

### 2.1 Login
After pasting the URL, you will face the following screen:  

<img src="https://i.imgur.com/KGSyHTm.png">

Provide the correct credentials, and click "Login".

---

### 2.2 Access RabbitMQ Console
You have now accessed the RabbitMQ Console:

<img src="https://i.imgur.com/AG1idsI.png">

---

### 2.3 Sending messages with the RabbitMQ Console
You can also send messages directly from the **Console**, by following the next steps:
```bash
Queues and Streams -> rabbitmq_queue -> Publish Message -> Payload 
```

After providing a **JSON** on the same format as mentioned before, click **"Publish message"**.

---
### 2.4 Practical example - RabbitMQ Console  
Following this path, should get you to the following screen:
 
<img src="https://i.imgur.com/KOOioPB.png" width="1100">

---

### 2.5 Logs  
After publishing our message, we can check the outcome on **Render**:

<img src="https://i.imgur.com/sCFjxcE.png" width="1100">

---


#### Now that you’ve finished this guide, you can return to the main documentation:  
- [🔙📖 Go back to README](./README.md)
