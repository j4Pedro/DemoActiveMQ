package com.pedro.demoactivemq.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer implements Runnable{

	@Override
	public void run() {

		try {
			//Create a connection factory.
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			//Create connection
			Connection connection = factory.createConnection();
			//Start the connection
			connection.start();
			//Create a session which is non transacctional
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Create Destination queue
			Destination queue = session.createQueue("Queue");
			
			//Create a producer
			MessageProducer producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			String message = "Pedro ActiveMQ Demo!!";
			
			//insert message
			TextMessage txtMessage = session.createTextMessage(message);
			System.out.println("Producer send :"+message);
			producer.send(txtMessage);
			
			
			session.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
