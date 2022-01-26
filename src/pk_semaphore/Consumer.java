package pk_semaphore;

import static pk_semaphore.PK_semaphore.buffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agnieszka
 */
public class Consumer implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while (i<=99){
            System.out.println(" consumed: "+buffer.get());  
            i++;
        }  
    }
    
}
