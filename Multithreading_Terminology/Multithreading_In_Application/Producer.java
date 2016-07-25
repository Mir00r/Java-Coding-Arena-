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
public class Producer implements Runnable{

    private SharedQueue < Product > sharedBuffer;

    public Producer(SharedQueue<Product> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }
    
  
    @Override
    public void run() {
        
        for ( int i = 1; i <= 10; i++ ) {
            try {
                produce ( new Product(i) );
                System.out.println("Produced : " + i);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void produce ( Product p ) throws InterruptedException {
        /*wait if buffer is full */
        while ( sharedBuffer.isFull()) {
            synchronized ( sharedBuffer ) {
                System.out.println("Buffer is full....." 
                        + Thread.currentThread().getName() + "is waiting.....");
                
                sharedBuffer.wait();
            }
        }
        
        /*Otherwise produce and notify consumer*/
        synchronized ( sharedBuffer ) {
            sharedBuffer.add(p);
            
            sharedBuffer.notifyAll();
        }
    }

}
