package com.pedro.demoactivemq;

import com.pedro.demoactivemq.consumer.Consumer;
import com.pedro.demoactivemq.producer.Producer;

public class TestActiveMQ {
	public static void main(String[] args) {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Thread producerThread = new Thread(producer);
		producerThread.start();
		
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		
	}
}
