/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_semaphore;

import java.util.concurrent.Semaphore;
/**
 *
 * @author Agnieszka
 */
public class Buffer implements IBuffer{
    private final int[] buffer = new int[10];
    private static int indexPut = 0, indexGet = 0;
    private final Semaphore isEmpty = new Semaphore(10);
    private final Semaphore isFull = new Semaphore(0);
    private final Semaphore lock = new Semaphore(1);
    
    @Override
    public void put(int v) {
        try {
            isEmpty.acquire();
            lock.acquire();
            buffer[indexPut] = v;
            indexPut = (indexPut +1) % 10;
            lock.release();
            isFull.release();
        } catch (InterruptedException ex) {
            System.out.println(" producer interrupted");
        }
    }

    @Override
    public int get() {
        int temp = 0;
        try {
            isFull.acquire();
            lock.acquire();
            temp = buffer[indexGet];
            indexGet = (indexGet +1) % 10;
            lock.release();
            isEmpty.release();
        } catch (InterruptedException ex) {
            System.out.println(" consumer interrupted");
        }
        return temp;
    }
}
