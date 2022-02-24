/*
 * ----Question no. 4----
 * WAP to show usage of Callable and demonstrate 
 * how it is different from Runnable
 * 
 */

//Callable()

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Demo implements Callable {
	@Override
	public Object call() throws Exception {

			Random obj = new Random();
			Integer r = obj.nextInt(5);	    // to get 5 random numbers
			Thread.sleep(r*1000);
			
		return r;
	}
}
public class CallableDemo{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask[] randomNoTasks = new FutureTask[5];
		for(int i=0; i<5; i++) {
			Callable obj = new Demo();
			randomNoTasks[i] = new FutureTask(obj);
			Thread t = new Thread(randomNoTasks[i]);
			t.start();
		}
		for(int i=0; i<5; i++) {
			Object o = randomNoTasks[i].get();
			System.out.println("Random Number: " +o);
		}
	}
}


/*
 * -----Difference between Callable Interface and Runnable Interface-----
 * 
 * * Callable interface is a part of java.util.concurrent package since Java 1.5, 
 * whereas Runnable interface is a part of java.lang package since Java 1.0.
 * 
 * * Callable interface can return the result of the parallel processing of a task,
 * whereas Runnable interface can return the return of computation.
 * 
 * * Callable interface throws a checked exception, whereas the other cannot throw
 * checked exception.
 * 
 * * In order to use Callable, we need to override the call(), whereas in a runnable 
 * interface, we need to override the run() method.
 * 
 */
