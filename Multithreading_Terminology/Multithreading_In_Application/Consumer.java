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
public class Consumer implements Runnable {

    private SharedQueue < Product > sharedBuffer;

    public Consumer ( SharedQueue<Product> sharedBuffer ) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
       
        while (true) {
            try {
                System.out.println("Consumed : " + consume());

                Thread.sleep(100);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private int consume () throws InterruptedException {
        /*wait if the buffer is empty */
        
        while ( sharedBuffer.isEmpty() ) {
            synchronized ( sharedBuffer ) {
                System.out.println("Buffer is empty....." 
                        +Thread.currentThread().getName() + "is waiting.........");
            
                sharedBuffer.wait();
            }
        }
        
        /*otherwise consume */
        synchronized ( sharedBuffer ) {
            sharedBuffer.notifyAll();
            
            return sharedBuffer.remove().getId();
        }
    }
}
