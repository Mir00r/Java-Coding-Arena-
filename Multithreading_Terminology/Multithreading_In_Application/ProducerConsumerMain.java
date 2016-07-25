/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test_code;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class ProducerConsumerMain {
    public static void main(String[] args) {
        final int SIZE = 5;
        final SharedQueue < Product > sharedBuffer = new SharedQueue<>(SIZE);
        
        /*Instantiating producer and consumer threads*/
        Thread producer = new Thread ( new Producer(sharedBuffer), "Producer");
        Thread consumer = new Thread ( new Consumer(sharedBuffer), "Consumer");
        
        /*Firing off threads*/
        producer.start();
        consumer.start();
    }
}
