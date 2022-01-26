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
public class Producer implements Runnable{

    @Override
    public void run() {
        int i =101;
        while(i<=200){
           buffer.put(i); 
           i++;
       }
    }

    
}
